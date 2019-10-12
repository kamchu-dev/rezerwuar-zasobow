package hackathon.rezerwuator.profile.intrastructure;

import hackathon.rezerwuator.profile.dto.MyRentDto;
import hackathon.rezerwuator.profile.dto.MyReservationDto;
import hackathon.rezerwuator.profile.dto.MyWishDto;
import hackathon.rezerwuator.profile.dto.ProfileDto;
import hackathon.rezerwuator.rent.dto.RentDto;
import hackathon.rezerwuator.reservation.dto.ReservationDto;
import hackathon.rezerwuator.resource.dto.ResourceDto;
import hackathon.rezerwuator.wish.dto.WishDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user/{id}/")
public class ProfileController {

    @GetMapping("profile")
    public ProfileDto getProfileForUser(@PathVariable("id") Long id) {
        List<MyRentDto> rents = Arrays.asList(new MyRentDto(
                new ResourceDto("Żemeł Jest Super",
                        "Wcale tego sam nie napisał",
                        UUID.randomUUID().toString(), UUID.randomUUID().toString()),
                new RentDto(UUID.randomUUID().toString(), id,
                        Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)),
                        Date.from(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.UTC))
                )));
        List<MyReservationDto> reservations = Arrays.asList(new MyReservationDto(
                new ResourceDto("Żemeł Jest Super",
                        "Wcale tego sam nie napisał",
                        UUID.randomUUID().toString(), UUID.randomUUID().toString()),
                new ReservationDto(1L))
        );
        List<MyWishDto> wishes = Arrays.asList(new MyWishDto(new WishDto(1L)));
        ProfileDto result = new ProfileDto(rents, reservations, wishes);
        return result;
    }

}
