package omgtu.carservice.controller;

import omgtu.carservice.service.CarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService serviceService) {
        this.carService = serviceService;
    }
}
