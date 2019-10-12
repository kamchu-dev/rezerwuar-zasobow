package hackathon.rezerwuator.like;

import hackathon.rezerwuator.like.dto.LikeDto;
import lombok.AllArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
public class LikesFacade {
    LikesRepository likesRepository;
    LikesFactory factory;

    public List<LikeDto> getAll(){
        return likesRepository.findAll()
                .stream()
                .map(entity -> new LikeDto(entity.getId(), entity.getUserId(), entity.getResourceCode()))
                .collect(toList());
    }

    public List<LikeDto> getAll(String resourceCode){
        return likesRepository.findByResourceCode(resourceCode)
                .stream()
                .map(entity -> new LikeDto(entity.getId(), entity.getUserId(), entity.getResourceCode()))
                .collect(toList());
    }

    public String like(Long userId, String resourceCode){
        //if not already reserved
        Likes likes = factory.like(userId, resourceCode);
        likesRepository.save(likes);
        return likes.getId();
    }

    public boolean canLike(String resourceCode){
        return !likesRepository.existsByResourceCodeAndUserId(resourceCode, 1L);
    }
}
