package omgtu.carservice.repository;

import omgtu.carservice.model.Spare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpareRepository extends JpaRepository<Spare, Long> {
}
