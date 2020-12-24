package cn.edu.cims.sunwa2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("cn.edu.cims.sunwa2.mapper")
public class Sunwa2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sunwa2Application.class, args);
	}

}
