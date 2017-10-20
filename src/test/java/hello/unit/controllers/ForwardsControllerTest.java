package hello.unit.controllers;

import hello.move.Movement;
import hello.movement.forwards.ForwardsController;
import hello.movement.response.Response;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ForwardsControllerTest {

    @Test
    public void getForwardsResponse() throws Exception {
        ForwardsController forwardsController = new ForwardsController();
        ForwardsController forwardsControllerSpy = Mockito.spy(forwardsController);

        class MovementSub implements Movement {}

        Mockito.doReturn(new MovementSub()).when(forwardsControllerSpy).getForwards();

        assertEquals(forwardsControllerSpy.response("name").getContent(), new Response(1, "Hello, name!").getContent());
    }
}