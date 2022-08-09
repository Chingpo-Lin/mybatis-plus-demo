package com.example.mybatisplus;

import com.example.mybatisplus.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatisplus.mapper")
public class MybatisPlusApplication {

	public static void main(String[] args) {

		SpringApplication.run(MybatisPlusApplication.class, args);

//		User user = User.builder()
//				.id(1)
//				.email("try@edu.com")
//				.phone("123456")
//				.build();
//
//		System.out.println(user);

	}

}
