package hello.tests;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import hello.movement.forwards.Forwards;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ForwardsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    Forwards forwards;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(8888).httpsPort(8889));

    @Test
    public void getHello() throws Exception {
        stubFor(get(urlEqualTo("/hits/forwards"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\":1,\"content\":\"Hello, World!\"}")));

        mvc.perform(MockMvcRequestBuilders.get("/hits/forwards").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"content\":\"Hello, World!\"}")));
    }
}