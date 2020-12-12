package omgtu.carservice.controller;

import omgtu.carservice.model.Service;
import omgtu.carservice.service.ServiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/services")
public class ServiceController {
    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<Service> getAll() {
        return serviceService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Service getById(@PathVariable(value = "id") Long id) {
        return serviceService.getById(id);
    }
}