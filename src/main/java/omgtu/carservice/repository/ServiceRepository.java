package omgtu.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import omgtu.carservice.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}