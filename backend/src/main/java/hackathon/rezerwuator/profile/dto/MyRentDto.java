package hackathon.rezerwuator.profile.dto;

import hackathon.rezerwuator.rent.dto.RentDto;
import hackathon.rezerwuator.resource.dto.ResourceDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyRentDto {

    private ResourceDto resource;
    private RentDto rentDto;
}
