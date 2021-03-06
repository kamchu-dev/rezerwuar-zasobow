package hackathon.rezerwuator.rent.infrastructure;

import hackathon.rezerwuator.rent.RentFacade;
import hackathon.rezerwuator.rent.dto.RentDto;
import hackathon.rezerwuator.rent.dto.RentRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/rent")
@AllArgsConstructor
public class RentController {

    private RentFacade rentFacade;

    @GetMapping("/api/rent")
    List<RentDto> getAll() {
        return rentFacade.getAll();
    }

    @GetMapping("/api/rent/user/{userId}")
    List<RentDto> getRentedByUser(@PathVariable Long userId) {
        return rentFacade.getRentedByUser(userId);
    }

    @GetMapping("/api/rent/available")
    List<RentDto> getAvailable() {
        return rentFacade.getByAvailability(false);
    }

    @GetMapping("/api/rent/rented")
    List<RentDto> getRented() {
        return rentFacade.getByAvailability(true);
    }

    @PostMapping("/api/rent")
    public void rent(@RequestBody  RentRequestDto rentRequestDto) {
        rentFacade.rent(rentRequestDto.getResourceCode(), rentRequestDto.getUserId());
    }

    @DeleteMapping("/api/rent/{resourceCode}")
    public void returnRentedResource(@PathVariable String resourceCode) {
        rentFacade.returnRentedResource(resourceCode);
    }

    @GetMapping("/api/rent/isRented")
    public boolean isRented(@PathVariable String resourceCode) {
        return rentFacade.isRented(resourceCode);
    }
}
