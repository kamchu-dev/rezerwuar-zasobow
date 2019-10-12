package hackathon.rezerwuator.wish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface WishRepository extends JpaRepository<Wish, String> {

}
