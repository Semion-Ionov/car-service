package omgtu.carservice.controller;

import omgtu.carservice.model.Spare;
import omgtu.carservice.service.SpareService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(path = "/spares")
public class SpareController {
    private final SpareService spareService;

    public SpareController(SpareService spareService) {
        this.spareService = spareService;
    }


    @GetMapping
    public List<Spare> getAll() {
        return spareService.getAll();
    }
}
