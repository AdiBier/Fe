package ab.fe.service;

import ab.fe.dao.entity.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface CustomerService extends UserDetailsService {

  Customer findCustomerById(Long id);

  Optional<Customer> findCustomerByEmail(String email);

  List<Customer> findAllCustomerList();

  Customer registerCustomer(Customer customer);

  boolean checkEmail(String email);
}
