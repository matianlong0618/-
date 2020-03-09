package com.baomidou.mybatisplus.samples.generator;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//启动类
@SpringBootApplication
@EnableSwagger2
@MapperScan("com/baomidou/mybatisplus/samples/generator")
public class GeneratorApplication {
    public static void main(String[] args){
        SpringApplication.run(GeneratorApplication.class,args);
    }
}

