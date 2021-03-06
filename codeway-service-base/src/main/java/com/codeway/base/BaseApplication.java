package com.codeway.base;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;

/**
 * 启动类
 **/
@EntityScan("com.codeway.pojo")
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableJpaRepositories("com.codeway.base.dao")
@EnableFeignClients(basePackages = "com.codeway.api")// 开启Feign的功能
// SpringBoot主配置类只会扫描自己所在的包及其子包下面,如果不加此扫描codeway-common里的公用包则扫描不到
@ComponentScan(basePackages = {"com.codeway"})
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

    /**
     * @param entityManager
     * @return
     * @see https://www.cnblogs.com/jpfss/p/11003964.html
     */
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

}
