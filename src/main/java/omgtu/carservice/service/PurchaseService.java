package omgtu.carservice.service;

import omgtu.carservice.model.Purchase;
import omgtu.carservice.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getByToken(String token) {
        var client = ActiveUsersService.getActiveUsersInstance().getUser(token);
        return purchaseRepository.getAllByClient(client);
    }
}
