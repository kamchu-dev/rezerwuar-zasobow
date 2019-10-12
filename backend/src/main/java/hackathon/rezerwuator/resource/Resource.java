package hackathon.rezerwuator.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
class Resource {
    String name;
    String description;
    List<String> tags;
    @Id
    String code;
    String qr;
}
