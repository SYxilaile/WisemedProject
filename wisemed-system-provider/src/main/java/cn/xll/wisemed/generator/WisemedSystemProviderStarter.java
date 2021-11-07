package cn.xll.wisemed.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>系统功能模块 - 基础用户 Provider 端启动类</b>
 * <p>
 *     用于系统行政人员、医生、护士等登录使用
 * </p>
 * @author wang
 * @version 1.0.0
 */
@MapperScan("cn.xll.wisemed.*.dao")
@EnableEurekaClient
@SpringBootApplication
public class WisemedSystemProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(WisemedSystemProviderStarter.class, args);
	}
}
