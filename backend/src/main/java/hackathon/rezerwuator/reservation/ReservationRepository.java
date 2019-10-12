package hackathon.rezerwuator.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
interface ReservationRepository extends JpaRepository<Reservation, String> {
    List<Reservation> deleteByResourceCodeAndUserId(String resourceCode, Long userId);
    List<Reservation> findByResourceCode(String resourceCode);

    List<Reservation> findByUserId(Long userId);

    List<Reservation> findByResourceCodeAndUserId(String resourceCode, Long userId);

    boolean existsByResourceCodeAndUserId(String resourceCode, Long userId);
}
