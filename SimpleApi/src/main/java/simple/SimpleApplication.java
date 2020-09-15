package simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@RestController
@SpringBootApplication
public class SimpleApplication {

  private static Logger log = LoggerFactory.getLogger(SimpleApplication.class);

  @RequestMapping(value = "/simple")
  public String simple() {
  log.info("Access /simple");

  return "Simple";
  }

  @RequestMapping(value = "/")
  public String home() {
  log.info("Access /");
  return "Hi!";
  }

  public static void main(String[] args) {
  SpringApplication.run(SimpleApplication.class, args);
  }
}