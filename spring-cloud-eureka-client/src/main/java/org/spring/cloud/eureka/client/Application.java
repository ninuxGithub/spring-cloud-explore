package org.spring.cloud.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Value("${server.port}")
	private String port;
	
	
	
	/**
	 * http://pc-shenzm2.mshome.net:8762/hi?name=java
	 * 
	 * 修改spring-cloud-eureka-client 项目的端口，然后启动， 建立集群
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "hi", method = RequestMethod.GET)
	public String clientTest(@RequestParam String name) {
		return "hello ," + name + "! you are visiting at port:" + port;
	}
}
