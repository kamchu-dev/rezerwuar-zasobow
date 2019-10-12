package hackathon.rezerwuator.reservation;

import hackathon.rezerwuator.resource.ResourceFacade;
import hackathon.rezerwuator.user.repository.UserRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
class ReservationFactory {

    private UserRepository userRepository;
    private ResourceFacade resourceFacade;
    private ReservationRepository reservationRepository;

    Reservation createReservation(Long userId, String resourceCode){
        userRepository.findById(userId).orElseThrow(() -> new RuntimeException(String.format("No user with id %s",userId)));
        if(Objects.isNull(resourceFacade.getResource(resourceCode))){
            throw new RuntimeException(String.format("No resource with code %s", resourceCode));
        }
        if(reservationRepository.existsByResourceCodeAndUserId(resourceCode, userId)){
            throw new RuntimeException(String.format("Already exiting reservation for code %s and user %d", resourceCode, userId));
        }
        return Reservation.builder()
                .id(UUID.randomUUID().toString())
                .reservationDate(LocalDateTime.now())
                .userId(userId)
                .resourceCode(resourceCode)
                .build();
    }

}
