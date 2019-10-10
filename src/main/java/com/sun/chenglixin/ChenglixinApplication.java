package com.sun.chenglixin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sun.chenglixin.mapper")
public class ChenglixinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChenglixinApplication.class, args);
	}
}
