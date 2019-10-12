package hackathon.rezerwuator.like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface LikesRepository extends JpaRepository<Likes, String> {
    List<Likes> deleteByResourceCodeAndUserId(String resourceCode, Long userId);
    List<Likes> findByResourceCode(String resourceCode);

    List<Likes> findByUserId(Long userId);

    List<Likes> findByResourceCodeAndUserId(String resourceCode, Long userId);

    boolean existsByResourceCodeAndUserId(String resourceCode, Long userId);
}
