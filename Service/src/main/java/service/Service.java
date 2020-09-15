package service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RestController
@RibbonClient(name = "simple-api", configuration = SimpleApiConfiguration.class)
public class Service {
  @LoadBalanced
  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Autowired
  RestTemplate restTemplate;

  @RequestMapping("/service")
  public String service() {
    String out = this.restTemplate.getForObject("http://simple-api/simple", String.class);
    return out;
  }

  public static void main(String[] args) {
    SpringApplication.run(Service.class, args);
  }
}
