package cn.xll.wisemed.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>智慧医疗信息平台 - 系统基础服务功能启动类</b>
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class WisemedSystemConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(WisemedSystemConsumerStarter.class, args);
	}
}
