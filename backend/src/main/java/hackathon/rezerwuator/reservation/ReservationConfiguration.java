package hackathon.rezerwuator.reservation;

import hackathon.rezerwuator.resource.ResourceFacade;
import hackathon.rezerwuator.user.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class ReservationConfiguration {

    @Bean
    public ReservationFacade getReservationFacade(ReservationRepository reservationRepository, ReservationFactory reservationFactory){
        return new ReservationFacade(reservationRepository, reservationFactory);
    }

    @Bean
    public ReservationFactory getReservationFactory(UserRepository userRepository, ResourceFacade resourceFacade, ReservationRepository reservationRepository){

        return new ReservationFactory(userRepository, resourceFacade, reservationRepository);
    }
}
