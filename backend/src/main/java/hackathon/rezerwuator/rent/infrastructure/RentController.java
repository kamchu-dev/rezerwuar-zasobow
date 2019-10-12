package hackathon.rezerwuator.rent.infrastructure;

import hackathon.rezerwuator.rent.RentFacade;
import hackathon.rezerwuator.rent.dto.RentDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/rent")
@AllArgsConstructor
public class RentController {

    private RentFacade rentFacade;

    @GetMapping("/api/rent")
    RentDto getAll(){
        return null;
    }
}
