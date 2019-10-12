package hackathon.rezerwuator.profile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ProfileDto {

    private List<MyRentDto> rents;
    private List<MyReservationDto> reservations;
    private List<MyWishDto> userRent;

}
