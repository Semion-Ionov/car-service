package omgtu.carservice.service;

import omgtu.carservice.model.Service;
import omgtu.carservice.repository.ServiceRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> getAll() {
        return serviceRepository.findAll();
    }

    public Service getById(Long id) {
        return serviceRepository.getOne(id);
    }
}
