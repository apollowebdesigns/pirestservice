package hello.unit;


import hello.movement.forwards.Forwards;
import hello.movement.forwards.ForwardsController;
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

@ContextConfiguration(classes = ForwardsController.class, loader = AnnotationConfigContextLoader.class)@RunWith(SpringRunner.class)
public class ForwardsTest {

    private MockMvc mockMvc;

    @MockBean
    private ForwardsController forwards;

    @Before
    public void setUp() {
        Forwards forwardsController= new Forwards();
        mockMvc = MockMvcBuilders.standaloneSetup(forwardsController).build();
    }

    Response response = new Response(1L, "some content");

    @Test
    public void movePiForwards() throws Exception {

        Mockito.when(
                forwards.response(Mockito.anyString())).thenReturn(response);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/hits/forwards").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = null;

        result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
    }

}
