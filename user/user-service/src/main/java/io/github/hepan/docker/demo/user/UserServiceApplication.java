package io.github.hepan.docker.demo.user;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/4 11:55
 **/

@SpringBootApplication
@EnableDubbo
@DubboComponentScan("io.github.hepan.docker.demo.user.service")
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class);
    }
}
