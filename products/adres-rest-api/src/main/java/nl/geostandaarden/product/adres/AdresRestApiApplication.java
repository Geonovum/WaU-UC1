package nl.geostandaarden.product.adres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.dotwebstack", "nl.geostandaarden.product.adres"})
public class AdresRestApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(AdresRestApiApplication.class, args);
  }
}
