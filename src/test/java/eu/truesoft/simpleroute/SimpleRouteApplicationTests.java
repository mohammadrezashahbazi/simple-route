package eu.truesoft.simpleroute;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class SimpleRouteApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenTestApp_thenEmptyResponse() throws Exception {

    }
}