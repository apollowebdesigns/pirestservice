package hello.unit.controllers;

import hello.move.Movement;
import hello.movement.right.RightController;
import hello.movement.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
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