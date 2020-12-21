package omgtu.carservice.service;

import omgtu.carservice.dto.DeleteRequestModel;
import omgtu.carservice.dto.DeleteResponseModel;
import omgtu.carservice.model.Order;
import omgtu.carservice.repository.ClientRepository;
import omgtu.carservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    public List<Order> saveAll(List<Order> orders) {
        return orderRepository.saveAll(orders);
    }

    public List<Order> getAll(String token) {
        var client = ActiveUsersService.getActiveUsersInstance().getUser(token);
        client = clientRepository.getOne(client.getId());
        return client.getOrders();
    }

    public DeleteResponseModel removeById(DeleteRequestModel id) {
        try {
            orderRepository.deleteById(id.getId());
        } catch (IllegalArgumentException ex) {
            return new DeleteResponseModel(400, ex.getMessage());
        }
        return new DeleteResponseModel(200, "Удаление прошло успешно");
    }
}
