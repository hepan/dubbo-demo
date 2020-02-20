package io.github.hepan.docker.demo.user.config;

import cn.hutool.core.util.IdUtil;
import com.ibeetl.starter.BeetlSqlCustomize;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.beetl.sql.core.IDAutoGen;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/4 15:17
 **/
@Slf4j
@Configuration
public class DBConfig {

    @Bean(name = "datasource")
    public DataSource getDataSource(Environment env) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        log.info("db url:{}", env.getProperty("spring.datasource.url"));
        return ds;
    }

    @Bean
    public BeetlSqlCustomize beetlSqlCustomize() {
        return new BeetlSqlCustomize() {
            @Override
            public void customize(SqlManagerFactoryBean sqlManagerFactoryBean) {
                System.out.println("------------------------------------------");
                //sqlManagerFactoryBean.setInterceptors(new Interceptor[]{new MyBTLDebugInterceptor()});
                Map<String, IDAutoGen> map = new HashMap<>(1);
                map.put("uuid", s -> IdUtil.simpleUUID());
                sqlManagerFactoryBean.setIdAutoGens(map);
//                map.put("snowflake" s->)
            }
        };
    }
}
