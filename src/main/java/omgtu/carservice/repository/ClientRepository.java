package omgtu.carservice.repository;

import omgtu.carservice.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmailAndPswd(String email, Short pswd);
}