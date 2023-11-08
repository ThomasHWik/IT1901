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

  /**
   * This method creates and returns a new instance of the ObjectMapper class.
   * The ObjectMapper class is used to convert JSON data to Java objects and vice versa.
   * @return a new instance of the ObjectMapper class.
   */
  @Bean
  public ObjectMapper objectMapperModule() {
    return new ObjectMapper();
  }

  /**
   * This class contains the main method that runs the PadelModelApplication.
   * The PadelModelApplication is a Spring Boot application that serves as the REST server for the PadelApp.
   * The main method calls the SpringApplication.run method to start the application.
   *
   * @param args The command line arguments passed to the application.
   */
  public static void main(String[] args) {
    SpringApplication.run(PadelModelApplication.class, args);
  }
}
