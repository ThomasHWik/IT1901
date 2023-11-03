package PadelApp.springboot.restserver;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * The Spring application.
 */
@SpringBootApplication
public class PadelModelApplication {

  @Bean
  public ObjectMapper objectMapperModule() {
    return new ObjectMapper();
  }

  public static void main(String[] args) {
    SpringApplication.run(PadelModelApplication.class, args);
  }
}
