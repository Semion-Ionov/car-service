package omgtu.carservice.repository;

import omgtu.carservice.model.Client;
import omgtu.carservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getAllByClient(Client client);

}
