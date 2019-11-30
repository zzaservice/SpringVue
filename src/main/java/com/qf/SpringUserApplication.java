package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringUserApplication {
    public static void main(String[] args) {
        System.out.println("启动类改变了");
        System.out.println("我又改变了");
        SpringApplication .run(SpringUserApplication.class);
    }
}
