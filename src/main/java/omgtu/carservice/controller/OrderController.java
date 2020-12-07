package omgtu.carservice.controller;

import omgtu.carservice.model.Order;
import omgtu.carservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService serviceService) {
        this.orderService = serviceService;
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @GetMapping
    public List<Order> getByToken(@CookieValue(value = "token")String token) {
        return orderService.getByToken(token);
    }
}