package cn.edu.cims.sunwa2.core;

import cn.edu.cims.sunwa2.model.Energy;
import cn.edu.cims.sunwa2.model.Order;
import cn.edu.cims.sunwa2.model.ProductNew;
import cn.edu.cims.sunwa2.model.Warnning;
import cn.edu.cims.sunwa2.service.EnergyService;
import cn.edu.cims.sunwa2.service.OrderService;
import cn.edu.cims.sunwa2.service.ProductNewService;
import cn.edu.cims.sunwa2.service.WarnningService;
import com.alibaba.fastjson.JSONObject;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈MQTT接收消息处理〉
 *
 * @author lenovo
 * @create 2018/6/4
 * @since 1.0.0
 */
@Configuration
@IntegrationComponentScan
public class MqttReceiveConfig {
    private static String orderNum;
    private static Integer amount;
    private static String progress;
    private static String guige;
    private static Integer orderEnergy;
    private static Integer energy;
    private static boolean switch_all = false;
    private static boolean productQuality = false;//未出现质量报警
    private static Integer productTime;
    // 板件数量
    private static Integer banjian_all;
    private static Integer banjian_left;

    @Value("${spring.mqtt.username}")
    private String username;

    @Value("${spring.mqtt.password}")
    private String password;

    @Value("${spring.mqtt.url}")
    private String hostUrl;

    @Value("${spring.mqtt.client.id}")
    private String clientId;

    @Value("${spring.mqtt.default.topic}")
    private String defaultTopic;

    @Value("${spring.mqtt.completionTimeout}")
    private int completionTimeout ;   //连接超时


    @Bean
    public MqttConnectOptions getMqttConnectOptions(){
        MqttConnectOptions mqttConnectOptions=new MqttConnectOptions();
        mqttConnectOptions.setUserName(username);
        mqttConnectOptions.setPassword(password.toCharArray());
        mqttConnectOptions.setServerURIs(new String[]{hostUrl});
        mqttConnectOptions.setKeepAliveInterval(2);
        return mqttConnectOptions;
    }
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(getMqttConnectOptions());
        return factory;
    }

    //接收通道
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    //配置client,监听的topic
    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(clientId+"_inbound", mqttClientFactory(),
                        "line2/robot1/state", "line2/robot2/state",
                        "line2/robot3/state","line2/robot4/state",
                        "line2/zhewanji1/state","line2/zhewanji2/state",
                        "line2/fanbianji/state","line2/dajiaoji/state","line2/chongchuang/state",
                        "line2/progress/order","line2/energy/order","line2/ordernum_front/order",
                        "line2/amount/order","line2/quality/order","line2/all/switch","line2/all/energy",
                        "line2/all/banjian_num","line2/left/banjian_num",
                        "line2/all/jin_num","line2/left/jin_num",
                        "line2/first/product","line2/second/product","line2/third/product",
                        "line2/time/product","line2/finish/product");
        adapter.setCompletionTimeout(completionTimeout);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Autowired
    private WarnningService warnningService;    //报警记录
    @Autowired
    private OrderService orderService;
    @Autowired
    private EnergyService energyService;
    @Autowired
    private ProductNewService productNewService;
    //通过通道获取数据
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
                String equip = topic.split("/")[1];
                String tag = topic.split("/")[2];
//                System.out.println(tag);
//                String type = topic.substring(topic.lastIndexOf("/")+1, topic.length());
                if (tag.equals("state")&& switch_all){
                    boolean data=(boolean) JSONObject.parseObject(message.getPayload().toString()).get("data");
                    System.out.println(equip+':'+tag+':'+data);
                    if (!data){
                        String equipName_zh="";
                        if (equip.equals("robot1")) equipName_zh="加强筋机器人";
                        if (equip.equals("robot2")) equipName_zh="组装机器人";
                        if (equip.equals("robot3")) equipName_zh="外包板机器人";
                        if (equip.equals("robot4")) equipName_zh="打胶机器人";
                        if (equip.equals("zhewanji1")) equipName_zh="加强筋折弯机";
                        if (equip.equals("zhewanji2")) equipName_zh="外包板折弯机";
                        if (equip.equals("fanbianji")) equipName_zh="翻边机";
                        if (equip.equals("dajiaoji")) equipName_zh="打胶机";
                        if (equip.equals("chongchuang")) equipName_zh="冲床";
                        Warnning warnning = new Warnning("轿壁线", equipName_zh, "运行异常", new Date(), "未处理");
                        warnningService.save(warnning);
                        System.out.println(equipName_zh+"报警");
                    }
                }
                else if (tag.equals("order")){
                    //标签位
                    if (equip.equals("ordernum_front")){
                        orderNum=String.valueOf(JSONObject.parseObject(message.getPayload().toString()).get("data"));
                        guige=orderNum.substring(orderNum.length()-1)+"00mm";
                        orderNum=orderNum.substring(0,orderNum.length()-1);
                        System.out.println("订单规格"+guige);
                        System.out.println("订单号："+orderNum);
                    }
                    if (equip.equals("progress")){
                        progress=String.valueOf(JSONObject.parseObject(message.getPayload().toString()).get("data"));
                        if (orderNum!=null){
                            Order order=new Order();
                            order.setProgress(Integer.parseInt(progress));
                            order.setOrdernumber(orderNum);
                            orderService.update(order);
                            System.out.println(progress);
                        }
                    }
                    if (equip.equals("amount")){
                        amount=Integer.parseInt(String.valueOf(JSONObject.parseObject(message.getPayload().toString()).get("data")));
                        System.out.println("订单数量"+amount);
                    }
                    // 订单是否正在执行
                    if (equip.equals("switch")){
                        boolean data=(boolean) JSONObject.parseObject(message.getPayload().toString()).get("data");
                        // 插入正在加工的订单，并去掉在排产计划中的订单
                        if (data){
                            // 确保订单号和数量不为空
                            if (orderNum!=null&&amount!=null){
                                // 判断是否在待加工队列内
                                if (!(orderService.listSelected("0",orderNum,null,null,null,null).isEmpty())){
                                    orderService.delete(orderNum,"0");
                                }
                                //判断该订单是否正在加工
                                if (orderService.listSelected("1", orderNum, null, null, null, null).isEmpty()){
                                    Order order=new Order();
                                    order.setOrdernumber(orderNum);
                                    order.setLinename("轿壁线");
                                    order.setAmount(amount);
                                    order.setProgress(0);
                                    order.setStatus("1");
                                    order.setGuige(guige);
                                    order.setStarttime(new Date());
                                    orderService.save(order);
                                    orderEnergy= energyService.listMostRecent().getTotal_energy();
                                    System.out.println("插入新订单："+orderNum);
                                }
                            }
                        }
                        else{
                            if (orderNum!=null){
                                // 判断当前订单是不是已经变为了历史订单
                                if (orderService.listSelected("2",orderNum,null,null,null,null).isEmpty()){
                                    Order order=new Order();
                                    order.setOrdernumber(orderNum);
                                    order.setFinishtime(new Date());
                                    order.setStatus("2");
                                    order.setEnergy(energyService.listMostRecent().getTotal_energy()-orderEnergy);
                                    order.setQuality(0);
                                    orderService.update(order);
                                }

                            }
                        }
                    }
//                    if (equip.equals("energy")){
//                        energy=Integer.parseInt(String.valueOf(JSONObject.parseObject(message.getPayload().toString()).get("data")));
//                        System.out.println("能耗："+energy);
//                    }
                }
                // 全局的报警标志，为true时，才检测报警
                else if(tag.equals("switch")){
                    switch_all=(boolean) JSONObject.parseObject(message.getPayload().toString()).get("data");
                    System.out.println(switch_all);
                }
                // 更新当日的能耗数据（修改数据库内最后一条）
                else if(tag.equals("energy")){
//                    System.out.println("jinle");
                    energy=Integer.parseInt(String.valueOf(JSONObject.parseObject(message.getPayload().toString()).get("data")));
                    Energy last_one = energyService.listMostRecent();
                    int last_energy = last_one.getTotal_energy();
                    Date date = last_one.getDate();
//                    System.out.println(energy);
//                    System.out.println(last_energy);
//                    System.out.println(date);
                    energyService.update(energy-last_energy,date);

                }
                // 良品检测
                else if(tag.equals("product")){
                    if (equip.equals("time")){
                        productTime=Integer.parseInt(String.valueOf(JSONObject.parseObject(message.getPayload().toString()).get("data")));
                    }
                    else if(equip.equals("finish")){
                        //加工完成，插入数据
                        if((boolean) JSONObject.parseObject(message.getPayload().toString()).get("data")){
                            if(orderNum!=null&&banjian_all!=null&&banjian_left!=null&&productTime!=null&&productNewService.listSelected(orderNum,String.valueOf(banjian_all-banjian_left),null,null).isEmpty()){
                                ProductNew product=new ProductNew();
                                product.setLineName("轿壁线");
                                product.setOrderNum(orderNum);
                                product.setQuality("合格");
                                product.setWorkpieceNum(String.valueOf(banjian_all-banjian_left));
                                product.setWorkTime(productTime);
                                productNewService.save(product);
                            }
                        }
                    }
                    else {
                        productQuality=(boolean) JSONObject.parseObject(message.getPayload().toString()).get("data");
                        // 一个位置不合格则插入记录
                        if (!productQuality){
                            if (orderNum!=null&&banjian_all!=null&&banjian_left!=null&&productNewService.listSelected(orderNum,String.valueOf(banjian_all-banjian_left),null,null).isEmpty()){
                                ProductNew product=new ProductNew();
                                product.setLineName("轿壁线");
                                product.setOrderNum(orderNum);
                                product.setQuality("不合格");
                                product.setWorkpieceNum(String.valueOf(banjian_all-banjian_left));
                                productNewService.save(product);
                            }
                        }
                    }
                }
                else if(tag.equals("banjian_num")){
                    if (equip.equals("all")){
                        banjian_all=Integer.parseInt(String.valueOf(JSONObject.parseObject(message.getPayload().toString()).get("data")));
                        System.out.println(banjian_all);
                    }
                    else if (equip.equals("left")){
                        banjian_left=Integer.parseInt(String.valueOf(JSONObject.parseObject(message.getPayload().toString()).get("data")));
                        System.out.println(banjian_left);
                    }
                }
            }
        };
    }
}


