package omgtu.carservice.service;

import omgtu.carservice.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository orderRepository) {
        this.carRepository = orderRepository;
    }
}
