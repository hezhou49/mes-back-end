package cn.edu.cims.sunwa2.core;

import cn.edu.cims.sunwa2.model.*;
import cn.edu.cims.sunwa2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 执行定时任务，定时访问数据库，查看机器报警状态，如果是报警状态，则添加一条报警信息入数据库
 */
@Component
public class AlarmRecord {

    /*
    * 后台处理报警，同一个报警是下降沿（1->0）触发的，
    如果数据库状态持续为false，需要判断是不是同一报警
    * */
    private static boolean quliaoRobFlag = false;  //取料机器人
    private static boolean cutMachineFlag = false;  //激光裁剪机

    @Autowired
    private DataPLCService dataPLCService;
    @Autowired
    private EnvLogService envLogService;
    @Autowired
    private EnergyService energyService;
    @Autowired
    private WarnningService warnningService;    //报警记录
    @Autowired
    private EnvThresholdService envThresholdService; //温度阈值


    // 每日oee统计
    @Scheduled(cron = "0 10 23 * * ?")  //每天23点10分
    public void oee() {
        System.out.println("每日oee统计");
        //访问plc数据表拿到每个设备的oee数据，插入数据库
    }

    // 能耗管理每日统计
    //@Scheduled(cron = "0 0 23 * * ?")  //每天23点
    public void energy() {
        System.out.println("能耗管理每日汇总");
        //获取energy表中最后一条数据，拿到上一次的总能耗

        //从plc_energy表中获取目前的能耗值，减去上述的总能耗，即为当日的总能耗

        // 拿到当前时间（date）
        // if:判断是否为1月1号，是：年度能耗=当日能耗，月度能耗=当日能耗。

        // else if:判断是否为1号，是：年度能耗叠加，月度能耗=当日能耗

        // else:普通日子：年度能耗叠加，月度能耗叠加。

        //插入数据库
    }


    //能耗每日新增一条
    @Scheduled(cron = "0 5 0 * * ?")  //每天0点5分
    public void energy1() {
        System.out.println("能耗管理每日新增");
        Energy last_energy = energyService.listMostRecent();
        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
        String month = sdf1.format(date);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
        String year = sdf2.format(date);
        //写入值
        last_energy.setLinename("轿壁线");
        last_energy.setDate(date);
        last_energy.setYear(year);
        last_energy.setMonth(month);
        //判断是否是新一月或新一年
        Calendar cal = Calendar.getInstance();
        int month_int=cal.get(Calendar.MONTH);//获取月份
        int day = cal.get(Calendar.DATE);
        if (day==1){
            last_energy.setMonth_energy(0);
            // month从0开始
            if (month_int==0){
                last_energy.setYear_energy(0);
            }
        }
        last_energy.setDay_energy(0);
        System.out.println(last_energy.toString());
        //插入数据库
        energyService.save(last_energy);
    }
    // 环境平均温度、湿度统计
    @Scheduled(cron = "0 5 23 * * ?")  //每天23点5分
    public void environment() {
        // 这个接口考虑一下，涉及到平均温度，是不是用mqtt收到数据然后直接写入数据库好呢？前端就可以直接去数据库取
        // 0628 平均温度和实时温度都让升华给，后端只需要每天定时往数据库插一条平均值即可
        System.out.println("环境平均温度、湿度统计");
        // 得到最后的平均温湿度
        List<DataPLC> humidity = dataPLCService.findByTag("avgHumidity");
        List<DataPLC> temperature = dataPLCService.findByTag("avgTemperature");
        //写入数据库
        EnvLog log=new EnvLog();
        log.setAverageHumidity(String.valueOf(humidity.get(0).getValue()));
        log.setAverageTemperature(String.valueOf(temperature.get(0).getValue()));
        log.setRecordTime(new Date());
        envLogService.save(log);
    }


}
