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

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getByToken(String token) {
        return orderRepository.getAllByClient(ActiveUsersService.getActiveUsersInstance()
                                                                     .getUser(token));
    }
}
