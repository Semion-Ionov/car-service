package omgtu.carservice.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import omgtu.carservice.model.Service;
import omgtu.carservice.repository.ServiceRepository;
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

public class ServiceControllerTests {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    //@MockBean
    private ServiceRepository repository;
    @Autowired
    private MockMvc mockMvc;

    int N;

    @BeforeEach
    public void before() {
        N = 10;
        addTestServices(N);
    }

    @Test
    @DisplayName(" getAllTest() succes")
    void getAllTest() throws Exception {
        mockMvc.perform(
                get("/services")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[4].name").value("name5"))
                .andExpect(jsonPath("$", hasSize(N)));
    }

    @Test
    @DisplayName(" getByIdTest() succes")
    public void getByIdTest() throws Exception {
        mockMvc.perform(get("/services/5"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("name5"));
    }

    @Test
    @DisplayName(" postRequestTest() succes")
    public void postRequestTest() throws Exception {
        mockMvc.perform(post("/services"))
                .andExpect(status().isMethodNotAllowed());
    }

    @AfterEach
    public void after() {
    }

    private void addTestServices(int n) {
        n = (n < 1) ? 1 : n;
        for (int i = 0; i < n; i++) {
            repository.save(createTestService((long) i + 1, "name" + Integer.toString(i + 1), new BigDecimal(i + 111)));
        }
    }

    private Service createTestService(Long id, String name, BigDecimal price) {
        Service service = new Service(id, name, price);
        return service;
    }
}
