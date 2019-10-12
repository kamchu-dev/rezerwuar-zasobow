package hackathon.rezerwuator.rent;

import org.springframework.context.annotation.Bean;

public class RentConfiguration {

    @Bean
    RentFacade getRentFacade(){
        return new RentFacade();
    }
}
