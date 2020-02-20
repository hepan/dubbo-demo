package io.github.hepan.docker.demo.message;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/4 15:48
 **/
@SpringBootApplication
@EnableDubbo
@DubboComponentScan("io.github.hepan.docker.demo.message.service")
public class MessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class);
    }
}
