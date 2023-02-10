package nl.geostandaarden.product.corelocation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.dotwebstack", "nl.geostandaarden.product.corelocation"})
public class CoreLocationLdApplication {

  public static void main(String[] args) {
    SpringApplication.run(CoreLocationLdApplication.class, args);
  }
}
