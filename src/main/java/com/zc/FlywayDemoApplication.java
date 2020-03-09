package com.zc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.zc.flywaydemo.dao")
@EnableTransactionManagement
public class FlywayDemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FlywayDemoApplication.class, args);
    }

}
