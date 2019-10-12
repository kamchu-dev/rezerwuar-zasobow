package hackathon.rezerwuator.like;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class Likes {
    @Id
    String id;
    Long userId;
    String resourceCode;
}
