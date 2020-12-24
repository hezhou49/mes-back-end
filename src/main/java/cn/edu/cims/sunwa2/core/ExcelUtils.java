package cn.edu.cims.sunwa2.core;

import cn.edu.cims.sunwa2.model.Order;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/3/12 13:41
 */
public class ExcelUtils {
    public static List<Order> excelToOrder(MultipartFile file){
        List<Order> list=new ArrayList<>();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            for (int i = 0; i <workbook.getNumberOfSheets() ; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
//                System.out.println("行数"+sheet.getPhysicalNumberOfRows());
                for (int j = 0; j <sheet.getPhysicalNumberOfRows() ; j++) {
                    // 跳过表头
                    if(j==0){
                        continue;
                    }

                    HSSFRow row = sheet.getRow(j);
//                    System.out.println("列数"+row.getPhysicalNumberOfCells());
                    if (row==null){
                        continue;
                    }

                    Order order = new Order();
                    for (int k = 0; k <row.getPhysicalNumberOfCells() ; k++) {
                        // 写固定了，每一列内容不能变
                        if(k==0){
                            //订单号
                            if (row.getCell(k).getStringCellValue().equals("")||row.getCell(k).getStringCellValue()==null){
                                break;
                            }
                            order.setOrdernumber(row.getCell(k).getStringCellValue());
                        }
                        else if(k==1){
                            //产线
                            order.setLinename(row.getCell(k).getStringCellValue());
                        }
//                        else if(k==2){
//                            // 订单时间
//                            order.setSubmittime(row.getCell(k).getDateCellValue());
//                        }
//                        else if(k==3){
//                            // 交货时间
//                            order.setDelivertime(row.getCell(k).getDateCellValue());
//                        }
                        else if(k==2){
                            // 规格
                            order.setGuige(row.getCell(k).getStringCellValue());
                        }
                        else if(k==3){
                            // 数量
                            order.setAmount(Integer.parseInt(row.getCell(k).getStringCellValue()));
                        }
                        else ;
                    }
                    order.setStatus("0");
                    if (order.getOrdernumber()!=null){
                        list.add(order);
                        System.out.println(order);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
