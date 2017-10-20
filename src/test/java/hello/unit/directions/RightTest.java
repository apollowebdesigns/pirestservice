package hello.unit.directions;


import hello.movement.right.Right;
import hello.movement.right.RightController;
import hello.movement.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = RightController.class, loader = AnnotationConfigContextLoader.class)@RunWith(SpringRunner.class)
public class RightTest {

    private MockMvc mockMvc;

    @MockBean
    private RightController Right;

    @Before
    public void setUp() {
        Right rightController = new Right();
        mockMvc = MockMvcBuilders.standaloneSetup(rightController).build();
    }

    Response response = new Response(1L, "some content");

    @Test
    public void movePiRight() throws Exception {

        Mockito.when(
                Right.response(Mockito.anyString())).thenReturn(response);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/hits/Right").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = null;

        result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
    }

}
