package hackathon.rezerwuator.rent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Getter
public class RentDto {
    String id;
    String resourceCode;
    Long userId;
    LocalDateTime rentDate;
    LocalDateTime untilDate;
    boolean rented;
}
