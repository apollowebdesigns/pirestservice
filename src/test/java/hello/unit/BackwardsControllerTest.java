package hello.unit;

import hello.move.Movement;
import hello.movement.backwards.BackwardsController;
import hello.movement.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BackwardsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getBackwardsResponse() throws Exception {
        BackwardsController backwardsController = new BackwardsController();
        BackwardsController backwardsControllerSpy = Mockito.spy(backwardsController);

        class MovementSub implements Movement {}

        Mockito.doReturn(new MovementSub()).when(backwardsControllerSpy).getBackwards();

        assertEquals(backwardsControllerSpy.response("name").getContent(), new Response(1, "Hello, name!").getContent());
    }
}