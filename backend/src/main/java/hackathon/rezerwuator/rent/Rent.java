package hackathon.rezerwuator.rent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
class Rent {
    @Id
    private String id;
    private String resourceCode;
    private Long userId;
    private LocalDateTime rentDate;
    private LocalDateTime untilDate;
    private boolean rented;


    public void returnResource(){
        if(rented){
            rented = false;
            untilDate = LocalDateTime.now();
        } else {
            throw new RuntimeException(String.format("Resource %s is not taken", resourceCode));
        }
    }

    public boolean isRented(){
        return rented;
    }
}
