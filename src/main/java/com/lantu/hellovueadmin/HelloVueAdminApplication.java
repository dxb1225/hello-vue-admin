package com.lantu.hellovueadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;
//dev1111111
@EnableOpenApi
@EnableWebMvc
@SpringBootApplication
@MapperScan("com.lantu.hellovueadmin.*.mapper")
public class HelloVueAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloVueAdminApplication.class, args);
    }

}
