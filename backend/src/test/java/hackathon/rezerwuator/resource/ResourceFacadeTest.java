package hackathon.rezerwuator.resource;

import hackathon.rezerwuator.resource.dto.ResourceDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ResourceFacadeTest {

    ResourceFacade facade;

    @Before
    public void setUp() throws Exception {
        InMemoryResourceRepository repository = new InMemoryResourceRepository();
        facade = new ResourceFacade(repository);
    }

    @Test
    public void getResource() {
        //given

        //when
        String code = facade.addResource("Test", "Tres", UUID.randomUUID().toString());

        //then
        ResourceDto resource = facade.getResource(code);
        assertEquals(code, resource.getCode());
    }


}
