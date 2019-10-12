package hackathon.rezerwuator.rent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface RentRepository  extends JpaRepository<Rent, String> {
    Optional<Rent> findByIdAndRentedIsFalse(String code);

    boolean existsByResourceCodeAndRentedIsTrue(String resourceCode);
    Optional<Rent> findByResourceCodeAndRentedIsFalse(String resourceCode);
    List<Rent> findAllByRented(boolean rented);

    Optional<Rent> findByResourceCodeAndRentedIsTrue(String resourceCode);
}
