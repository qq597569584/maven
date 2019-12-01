package com.baizhi;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.baizhi.dao")
@SpringBootApplication
public class AppCat {
    public static void main(String[] args) {

        SpringApplication.run(AppCat.class, args);
        System.out.println("--------------");
    }

}
