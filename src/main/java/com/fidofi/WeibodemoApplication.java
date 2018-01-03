package com.fidofi;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ServletComponentScan
//@MapperScan({"com.fidofi.mapper","com.fidofi.dao"}) //这里的mapper是mybatis的mapper目录
//@MapperScan({"classpath:/mapper/*.xml","com.fidofi.dao"}) //这里的mapper是mybatis的mapper目录
@MapperScan("com.fidofi.dao")
public class WeibodemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeibodemoApplication.class, args);
    }

}
