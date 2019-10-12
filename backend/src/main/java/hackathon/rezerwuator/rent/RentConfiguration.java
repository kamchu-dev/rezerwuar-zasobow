package hackathon.rezerwuator.rent;

import hackathon.rezerwuator.resource.ResourceFacade;
import hackathon.rezerwuator.user.repository.UserRepository;
import org.springframework.context.annotation.Bean;

public class RentConfiguration {

    @Bean
    RentFacade getRentFacade(RentFactory rentFactory, RentRepository rentRepository, ResourceFacade resourceFacade){
        return new RentFacade(rentFactory, rentRepository, resourceFacade);
    }

    @Bean
    RentFactory getRentFactory(RentRepository rentRepository, UserRepository userRepository){
        return new RentFactory(rentRepository, userRepository);
    }
}
