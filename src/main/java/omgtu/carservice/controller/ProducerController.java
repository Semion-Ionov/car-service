package omgtu.carservice.controller;

import omgtu.carservice.service.ProducerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/producers")
public class ProducerController {
    private final ProducerService producerService;

    public ProducerController(ProducerService serviceService) {
        this.producerService = serviceService;
    }
}
