package omgtu.carservice.service;

import omgtu.carservice.repository.ProducerRepository;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private final ProducerRepository producerRepository;

    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }
}
