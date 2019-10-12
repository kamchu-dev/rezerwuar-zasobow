package hackathon.rezerwuator.rent;

import hackathon.rezerwuator.resource.ResourceFacade;
import hackathon.rezerwuator.resource.dto.ResourceDto;
import hackathon.rezerwuator.user.User;
import hackathon.rezerwuator.user.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RentFacadeTest {

  /*  RentFacade rentFacade;
    RentFactory rentFactory;
    RentRepository rentRepository;
    ResourceFacade resourceFacade = Mockito.mock(ResourceFacade.class);
    UserRepository userRepository = Mockito.mock(UserRepository.class);

    @Before
    public void setUp() throws Exception {
        rentRepository = new InMemoryRentRepository();
        rentFactory = new RentFactory(rentRepository, userRepository, resourceFacade);
        rentFacade = new RentFacade(rentFactory, rentRepository, resourceFacade);
    }

    @Test
    public void shouldRent(){
        //given
        long userId = 1L;
        String resourceCode = UUID.randomUUID().toString();
        when(userRepository.findById(Mockito.eq(userId))).thenReturn(Optional.of(new User()));
        when(resourceFacade.getResource(Mockito.eq(resourceCode))).thenReturn(new ResourceDto(null, null, resourceCode, null, 0));

        //when

        rentFacade.rent(resourceCode, userId);

        //then
        boolean rented = rentFacade.isRented(resourceCode);
        assertTrue(rented);

    }

    @Test
    public void shouldReturnRentedResource(){
        //given
        long userId = 1L;
        String resourceCode = UUID.randomUUID().toString();
        when(userRepository.findById(Mockito.eq(userId))).thenReturn(Optional.of(new User()));
        when(resourceFacade.getResource(Mockito.eq(resourceCode))).thenReturn(new ResourceDto(null, null, resourceCode, null, 0));
        rentFacade.rent(resourceCode, userId);

        //when
        rentFacade.returnRentedResource(resourceCode);;

        //then
        boolean rented = rentFacade.isRented(resourceCode);
        assertFalse(rented);

    }*/
}