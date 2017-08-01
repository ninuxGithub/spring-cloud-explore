package org.spring.cloud.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;

	public String hiService(String name) {
		// spring-cloud-eureka-client client appliction name 大写
		//访问的服务的名称不变，但是随着端口的切换，底层访问的client 发生了变化
		return restTemplate.getForObject("http://SPRING-CLOUD-EUREKA-CLIENT/hi?name=" + name, String.class);
	}

}
