package hello.unit.controllers;

import hello.horn.Horn;
import hello.horn.HornController;
import hello.movement.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HornControllerTest {

    @Test
    public void getHornResponse() throws Exception {
        HornController hornController = new HornController();
        HornController hornControllerSpy = Mockito.spy(hornController);

        class HornSub implements Horn {}

        Mockito.doReturn(new HornSub()).when(hornControllerSpy).getHorn();

        assertEquals(hornControllerSpy.response("name").getContent(), new Response(1, "Hello, name!").getContent());
    }
}