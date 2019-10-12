package hackathon.rezerwuator.reservation;

import hackathon.rezerwuator.profile.dto.MyReservationDto;
import hackathon.rezerwuator.reservation.dto.ReservationDto;
import lombok.AllArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
public class ReservationFacade {
    ReservationRepository reservationRepository;
    ReservationFactory factory;

    public List<ReservationDto> getAll(){
        return reservationRepository.findAll()
                .stream()
                .map(entity -> new ReservationDto(entity.getId(), entity.getUserId(), entity.getResourceCode(), entity.getReservationDate()))
                .collect(toList());
    }

    public List<ReservationDto> getAll(String resourceCode){
        return reservationRepository.findByResourceCode(resourceCode)
                .stream()
                .map(entity -> new ReservationDto(entity.getId(), entity.getUserId(), entity.getResourceCode(), entity.getReservationDate()))
                .collect(toList());
    }

    public String reserve(Long userId, String resourceCode){
        //if not already reserved
        Reservation reservation = factory.createReservation(userId, resourceCode);
        reservationRepository.save(reservation);
        return reservation.id;
    }

    public List<ReservationDto> cancelReservation(Long userId, String resourceCode){
        return reservationRepository.deleteByResourceCodeAndUserId(resourceCode, userId)
                .stream()
                .map(entity -> new ReservationDto(entity.getId(), entity.getUserId(), entity.getResourceCode(), entity.getReservationDate()))
                .collect(toList());
    }

    public List<ReservationDto> getAllForUser(Long userId) {
        return reservationRepository.findByUserId(userId)
                .stream()
                .map(entity -> new ReservationDto(entity.getId(), entity.getUserId(), entity.getResourceCode(), entity.getReservationDate()))
                .collect(toList());

    }
}
