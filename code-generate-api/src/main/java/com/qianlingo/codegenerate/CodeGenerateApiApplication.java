package com.qianlingo.codegenerate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 启动类
 * @author QianLinGooo
 * @since create in 2021/07/14
 */
@SpringBootApplication
@MapperScan("com.qianlingo.codegenerate.**.mybatis.mapper")
public class CodeGenerateApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeGenerateApiApplication.class, args);
    }

}
