package hackathon.rezerwuator.wish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
class Wish {
    String name;
    String description;
    @Id
    String code;
    String qr;
    String money;
    String url;
    boolean canLike;
}
