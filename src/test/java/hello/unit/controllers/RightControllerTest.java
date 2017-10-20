package hello.unit.controllers;

import hello.move.Movement;
import hello.movement.response.Response;
import hello.movement.right.RightController;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class RightControllerTest {

    @Test
    public void getRightResponse() throws Exception {
        RightController RightController = new RightController();
        RightController RightControllerSpy = Mockito.spy(RightController);

        class MovementSub implements Movement {}

        Mockito.doReturn(new MovementSub()).when(RightControllerSpy).getRight();

        assertEquals(RightControllerSpy.response("name").getContent(), new Response(1, "Hello, name!").getContent());
    }
}