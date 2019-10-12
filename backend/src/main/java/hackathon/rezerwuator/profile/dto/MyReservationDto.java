package hackathon.rezerwuator.profile.dto;

import hackathon.rezerwuator.reservation.dto.ReservationDto;
import hackathon.rezerwuator.resource.dto.ResourceDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyReservationDto {

    private ResourceDto resource;
    private ReservationDto reservation;
}
