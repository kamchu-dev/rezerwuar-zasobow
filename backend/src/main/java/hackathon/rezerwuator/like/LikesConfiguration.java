package hackathon.rezerwuator.like;

import hackathon.rezerwuator.like.dto.LikeDto;
import hackathon.rezerwuator.resource.dto.ResourceDto;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.UUID;


public class LikesConfiguration {

    @Bean
    public LikesFacade getLikesFacade(LikesRepository likesRepository, LikesFactory likesFactory){
        LikesFacade likesFacade = new LikesFacade(likesRepository, likesFactory);
        ArrayList<LikeDto> likeDtos = new ArrayList<>();
        likeDtos.add(new LikeDto(UUID.randomUUID().toString(),
                1L,
                "stalykod"
                ));
        likeDtos.forEach(dto -> likesFacade.like(dto.getUserId(), dto.getResourceCode()));
        return likesFacade;
    }

    @Bean
    public LikesFactory getLikesFactory(LikesRepository likesRepository){

        return new LikesFactory(likesRepository);
    }
}
