package hello.unit.controllers;

import hello.move.Movement;
import hello.movement.backwards.BackwardsController;
import hello.movement.response.Response;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class BackwardsControllerTest {

    @Test
    public void getBackwardsResponse() throws Exception {
        BackwardsController backwardsController = new BackwardsController();
        BackwardsController backwardsControllerSpy = Mockito.spy(backwardsController);

        class MovementSub implements Movement {}

        Mockito.doReturn(new MovementSub()).when(backwardsControllerSpy).getBackwards();

        assertEquals(backwardsControllerSpy.response("name").getContent(), new Response(1, "Hello, name!").getContent());
    }
}