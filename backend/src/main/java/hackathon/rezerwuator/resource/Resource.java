package hackathon.rezerwuator.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
class Resource {
    String name;
    String description;
    @ElementCollection(targetClass=String.class, fetch = FetchType.EAGER)
    List<String> tags;
    @Id
    String code;
    String qr;
}
