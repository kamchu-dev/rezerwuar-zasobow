package hackathon.rezerwuator;

import hackathon.rezerwuator.config.JpaConfig;
import hackathon.rezerwuator.rent.RentConfiguration;
import hackathon.rezerwuator.resource.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Import({JpaConfig.class, ResourceConfig.class, RentConfiguration.class})
public class HackathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackathonApplication.class, args);
    }

}
