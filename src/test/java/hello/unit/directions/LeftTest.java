package hello.unit.directions;


import hello.movement.left.Left;
import hello.movement.left.LeftController;
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

@ContextConfiguration(classes = LeftController.class, loader = AnnotationConfigContextLoader.class)@RunWith(SpringRunner.class)
public class LeftTest {

    private MockMvc mockMvc;

    @MockBean
    private LeftController Left;

    @Before
    public void setUp() {
        Left leftController = new Left();
        mockMvc = MockMvcBuilders.standaloneSetup(leftController).build();
    }

    Response response = new Response(1L, "some content");

    @Test
    public void movePiLeft() throws Exception {

        Mockito.when(
                Left.response(Mockito.anyString())).thenReturn(response);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/hits/left").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = null;

        result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
    }

}
