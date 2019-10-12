package hackathon.rezerwuator.reservation;

import hackathon.rezerwuator.reservation.dto.ReservationDto;
import hackathon.rezerwuator.resource.ResourceFacade;
import hackathon.rezerwuator.resource.dto.ResourceDto;
import hackathon.rezerwuator.user.User;
import hackathon.rezerwuator.user.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReservationFacadeTest {

    /*UserRepository userRepository = Mockito.mock(UserRepository.class);
    ResourceFacade resourceFacade = Mockito.mock(ResourceFacade.class);

    ReservationRepository reservationRepository;
    ReservationFactory reservationFactory;
    ReservationFacade reservationFacade;

    @Before
    public void setUp() throws Exception {
        reservationRepository = new InMemoryReservationRepository();
        reservationFactory = new ReservationFactory(userRepository, resourceFacade,reservationRepository);
        reservationFacade = new ReservationFacade(reservationRepository, reservationFactory);
    }

    @Test
    public void shouldReserve() {
        //given
        Long userId = 1L;
        String resourceCode = UUID.randomUUID().toString();
        when(userRepository.findById(Mockito.eq(userId))).thenReturn(Optional.of(new User()));
        when(resourceFacade.getResource(Mockito.eq(resourceCode))).thenReturn(new ResourceDto(null, null, resourceCode, null, 0));

        //when
        reservationFacade.reserve(userId, resourceCode);

        //then
        List<ReservationDto> reservations = reservationFacade.getAll(resourceCode);
        assertEquals(1, reservations.size());
        assertEquals(resourceCode, reservations.get(0).getResourceCode());
        assertEquals(userId, reservations.get(0).getUserId());
    }

    @Test
    public void shouldCancelReservations() {
        //given
        Long userId = 1L;
        String resourceCode = UUID.randomUUID().toString();
        when(userRepository.findById(Mockito.eq(userId))).thenReturn(Optional.of(new User()));
        when(resourceFacade.getResource(Mockito.eq(resourceCode))).thenReturn(new ResourceDto(null, null, resourceCode, null, 0));
        reservationFacade.reserve(userId, resourceCode);

        //when
        reservationFacade.cancelReservation(userId, resourceCode);

        //then
        List<ReservationDto> reservations = reservationFacade.getAll(resourceCode);
        assertEquals(0, reservations.size());
    }*/
}