package omgtu.carservice.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import omgtu.carservice.model.Spare;
import omgtu.carservice.repository.SpareRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")

public class SpareControllerTests {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    //@MockBean
    private SpareRepository repository;
    @Autowired
    private MockMvc mockMvc;

    int N;

    @BeforeEach
    public void before() {
        N = 10;
        addTestSpares(N);
    }

    @Test
    @DisplayName(" getAllTest() succes")
    void getAllTest() throws Exception {
        mockMvc.perform(
                get("/spares")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[4].type").value("type5"))
                .andExpect(jsonPath("$", hasSize(N)));
    }

    @Test
    @DisplayName(" getByIdTest() succes")
    public void getByIdTest() throws Exception {
        mockMvc.perform(get("/spares/5"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.type").value("type5"));
    }

    @Test
    @DisplayName(" postRequestTest() succes")
    public void postRequestTest() throws Exception {
        mockMvc.perform(post("/spares"))
                .andExpect(status().isMethodNotAllowed());
    }

    @AfterEach
    public void after() {
    }

    private void addTestSpares(int n) {
        n = (n < 1) ? 1 : n;
        for (int i = 0; i < n; i++) {
            repository.save(createTestSpare((long) i + 1, (long) i + 1, "type" + Integer.toString(i + 1),
                    "name" + Integer.toString(i + 1), "manufacturer" + Integer.toString(i + 1),
                    new BigDecimal(i + 111), "imgPath"));
        }
    }

    private Spare createTestSpare(Long id, Long categoryId, String type, String name, String manufacturer, BigDecimal price, String img) {
        Spare spare = new Spare(id, categoryId, type, name, manufacturer, price, img);
        return spare;
    }
}
