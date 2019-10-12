package hackathon.rezerwuator.rent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class RentDto {
    String resourceCode;
    Long userId;
    Date rentDate;
    Date untilDate;
}
