package ab.fe.dao.repository;

import ab.fe.dao.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  Optional<Customer> findCustomerByEmail(String email);

  boolean existsByEmail(String email);

  @Query("SELECT user FROM Customer user " + "WHERE (:login = user.email)")
  Optional<Customer> findByLogin(String login);
}
