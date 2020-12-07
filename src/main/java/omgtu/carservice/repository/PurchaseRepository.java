package omgtu.carservice.repository;

import omgtu.carservice.model.Client;
import omgtu.carservice.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> getAllByClient(Client client);
}