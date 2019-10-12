package hackathon.rezerwuator.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
class Reservation {

    @Id
    String id;
    Long userId;
    String resourceCode;
    LocalDateTime reservationDate;
}
