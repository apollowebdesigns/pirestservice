package hello.unit.controllers;

import hello.move.Movement;
import hello.movement.left.LeftController;
import hello.movement.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
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