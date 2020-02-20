package io.github.hepan.docker.demo.user.edge;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/5 08:47
 **/
@SpringBootApplication
@EnableDubboConfig
@DubboComponentScan("io.github.hepan.docker.demo.user.edge")

public class UserEdgeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserEdgeServiceApplication.class);
    }
}
