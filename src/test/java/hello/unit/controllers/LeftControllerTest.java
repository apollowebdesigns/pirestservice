package hello.unit.controllers;

import hello.move.Movement;
import hello.movement.left.LeftController;
import hello.movement.response.Response;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class LeftControllerTest {

    @Test
    public void getLeftResponse() throws Exception {
        LeftController LeftController = new LeftController();
        LeftController LeftControllerSpy = Mockito.spy(LeftController);

        class MovementSub implements Movement {}

        Mockito.doReturn(new MovementSub()).when(LeftControllerSpy).getLeft();

        assertEquals(LeftControllerSpy.response("name").getContent(), new Response(1, "Hello, name!").getContent());
    }
}