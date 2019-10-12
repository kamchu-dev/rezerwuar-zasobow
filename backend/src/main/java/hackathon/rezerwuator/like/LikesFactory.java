package hackathon.rezerwuator.like;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
class LikesFactory {

    private LikesRepository likesRepository;

    Likes like(Long userId, String resourceCode){
        if(likesRepository.existsByResourceCodeAndUserId(resourceCode, userId)){
            throw new RuntimeException(String.format("Already like resource for code %s and user %d", resourceCode, userId));
        }
        return Likes.builder()
                .id(UUID.randomUUID().toString())
                .userId(userId)
                .resourceCode(resourceCode)
                .build();
    }

}
