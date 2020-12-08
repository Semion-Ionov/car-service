package omgtu.carservice.service;

import omgtu.carservice.model.Spare;
import omgtu.carservice.repository.SpareRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpareService {
    private final SpareRepository spareRepository;

    public SpareService(SpareRepository spareRepository) {
        this.spareRepository = spareRepository;
    }

    public List<Spare> getAll() {
        return spareRepository.findAll();
    }

    public Spare getById(Long id) {
        return spareRepository.findById(id).get();
    }
}
