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
import java.util.Collections;
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
                        UUID.randomUUID().toString(), UUID.randomUUID().toString(), 5, Arrays.asList("Żemeł tego nie pisał","Fajność","Klasa","Szyk"), false, true),
                new RentDto(UUID.randomUUID().toString(),
                        UUID.randomUUID().toString(),
                        id,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusDays(1),
                        true)
                ));
        List<MyReservationDto> reservations = Arrays.asList(new MyReservationDto(
                new ResourceDto("Żemeł Jest Super",
                        "Wcale tego sam nie napisał",
                        UUID.randomUUID().toString(), UUID.randomUUID().toString(), 5,Arrays.asList("Żemeł tego nie pisał","Fajność","Klasa","Szyk"), false, true),
                new ReservationDto(UUID.randomUUID().toString(), 1L, UUID.randomUUID().toString(), LocalDateTime.now()))
        );
        List<MyWishDto> wishes = Arrays.asList(new MyWishDto(new WishDto("Żemeł Jest Super",
                "Wcale tego sam nie napisał",
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "113.50 $", "https://www.amazon.com/Java-Dummies-Computers-Barry-Burd/dp/1119175690", 7)));
        ProfileDto result = new ProfileDto(rents, reservations, wishes);
        return result;
    }

}
