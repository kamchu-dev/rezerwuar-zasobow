package hackathon.rezerwuator.rent;

import hackathon.rezerwuator.resource.ResourceFacade;
import hackathon.rezerwuator.user.repository.UserRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
class RentFactory {
    private RentRepository rentRepository;
    private UserRepository userRepository;
    private ResourceFacade resourceFacade;

    public Rent createRent(String resourceCode, Long userId){
        userRepository.findById(userId).orElseThrow(() -> new RuntimeException(String.format("No user with id %s",userId)));
        if(Objects.isNull(resourceFacade.getResource(resourceCode))){
            throw new RuntimeException(String.format("No resource with code %s", resourceCode));
        }
        LocalDateTime now = LocalDateTime.now();
        rentRepository.findByResourceCodeAndRentedIsFalse(resourceCode)
            .ifPresent(rent -> {
                throw new RuntimeException(String.format("Resource with code %s is already taken", resourceCode));
            });

        return Rent.builder()
                .id(UUID.randomUUID().toString())
                .resourceCode(resourceCode)
                .userId(userId)
                .rentDate(now)
                .untilDate(now.plusMonths(1))
                .rented(true)
                .build();
    }
}
