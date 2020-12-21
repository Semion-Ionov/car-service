package omgtu.carservice.service;

import omgtu.carservice.model.Order;
import omgtu.carservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> saveAll(List<Order> orders) {
        return orderRepository.saveAll(orders);
    }

    public List<Order> getAll(String token) {
        var client = ActiveUsersService.getActiveUsersInstance().getUser(token);
        return client.getOrders();
    }
}
