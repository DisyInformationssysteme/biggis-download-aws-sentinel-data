package net.disy.biggis.sentinel.download;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("net.disy.biggis.sentinel")
public class AwsBucketImportApplication {

  public static void main(String[] args) {
    SpringApplication.run(AwsBucketImportApplication.class, args);
  }
}
