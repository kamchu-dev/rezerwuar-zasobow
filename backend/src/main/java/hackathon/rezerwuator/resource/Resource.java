package hackathon.rezerwuator.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
class Resource {
    String name;
    String description;
    String tags;
    @Id
    String code;
    String qr;
}
