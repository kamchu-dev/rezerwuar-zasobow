package hackathon.rezerwuator.reservation.infrastructure;

import hackathon.rezerwuator.reservation.ReservationFacade;
import hackathon.rezerwuator.reservation.dto.ReservationDto;
import hackathon.rezerwuator.reservation.dto.ReservationRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/reservation")
@AllArgsConstructor
class ReservationController {
    ReservationFacade reservationFacade;

    @GetMapping("/api/reservation")
    List<ReservationDto> getAll(){
        return reservationFacade.getAll();
    }

    @GetMapping("/api/reservation/code/{resourceCode}")
    List<ReservationDto> getAll(@PathVariable String resourceCode){
        return reservationFacade.getAll(resourceCode);
    }

    @GetMapping("/api/reservation/user/{userId}")
    List<ReservationDto> getAllForUser(@PathVariable Long userId){
        return reservationFacade.getAllForUser(userId);
    }

    @PostMapping("/api/reservation")
    String reserve(@RequestBody ReservationRequestDto reservationRequestDto){
        return reservationFacade.reserve(reservationRequestDto.getUserId(), reservationRequestDto.getResourceCode());
    }

    @DeleteMapping("/api/reservation/user/{userId}/code/{resourceCode}")
    List<ReservationDto> cancelReservation(@PathVariable Long userId, @PathVariable String resourceCode){
        return reservationFacade.cancelReservation(userId, resourceCode);
    }
}
