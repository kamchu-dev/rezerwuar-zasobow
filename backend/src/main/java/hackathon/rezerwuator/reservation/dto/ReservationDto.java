package hackathon.rezerwuator.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
public class ReservationDto {
    String id;
    Long userId;
    String resourceCode;
    LocalDateTime reservationDate;
}
