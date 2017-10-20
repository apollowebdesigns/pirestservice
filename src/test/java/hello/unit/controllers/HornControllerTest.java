package hello.unit.controllers;

import hello.horn.Horn;
import hello.horn.HornController;
import hello.movement.response.Response;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

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