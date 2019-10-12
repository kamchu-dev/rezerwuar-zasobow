package hackathon.rezerwuator.rent;

import hackathon.rezerwuator.rent.dto.RentDto;
import hackathon.rezerwuator.resource.ResourceFacade;
import hackathon.rezerwuator.resource.dto.ResourceDto;
import hackathon.rezerwuator.user.repository.UserRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RentFacade {
    private RentFactory rentFactory;
    private RentRepository rentRepository;

    public List<RentDto> getAll(){
        return rentRepository.findAll()
                .stream()
                .map(entity -> new RentDto(
                        entity.getId(),
                        entity.getResourceCode(),
                        entity.getUserId(),
                        entity.getRentDate(),
                        entity.getUntilDate(),
                        entity.isRented()
                ))
                .collect(Collectors.toList());
    }

    public void rent(String resourceCode, Long userId){
        Rent rent = rentFactory.createRent(resourceCode, userId);
        rentRepository.save(rent);
    }

    public void returnRentedResource(String resourceCode){
 /*       if(Objects.isNull(resourceFacade.getResource(resourceCode))){
            throw new RuntimeException(String.format("No resource with code %s", resourceCode));
        }*/
        Rent rent = rentRepository.findByResourceCodeAndRentedIsTrue(resourceCode)
                .orElseThrow(() -> new RuntimeException(String.format("Could not find Rent for resource%s", resourceCode)));
        rent.returnResource();
    }

    public boolean isRented(String resourceCode){
        return rentRepository.existsByResourceCodeAndRentedIsTrue(resourceCode);
    }

    public List<RentDto> getByAvailability(boolean rented){
        return rentRepository.findAllByRented(rented).stream()
                .map(entity -> new RentDto(
                        entity.getId(),
                        entity.getResourceCode(),
                        entity.getUserId(),
                        entity.getRentDate(),
                        entity.getUntilDate(),
                        entity.isRented()
                ))
                .collect(Collectors.toList());
    }

    public List<RentDto> getRentedByUser(Long userId) {
        return rentRepository.findAllByUserIdAndRentedIsTrue(userId)
                .stream()
                .map(entity -> new RentDto(
                        entity.getId(),
                        entity.getResourceCode(),
                        entity.getUserId(),
                        entity.getRentDate(),
                        entity.getUntilDate(),
                        entity.isRented()
                ))
                .collect(Collectors.toList());
    }
}
