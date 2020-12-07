package omgtu.carservice.controller;

import omgtu.carservice.model.Purchase;
import omgtu.carservice.service.PurchaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService serviceService) {
        this.purchaseService = serviceService;
    }

    @PostMapping
    public Purchase save(Purchase purchase) {
        return purchaseService.save(purchase);
    }

    @GetMapping
    public List<Purchase> getByToken(@CookieValue(value = "token")String token) {
        return purchaseService.getByToken(token);
    }
}