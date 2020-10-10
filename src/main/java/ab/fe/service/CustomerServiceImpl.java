package ab.fe.service;

import ab.fe.dao.entity.Customer;
import ab.fe.dao.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;

  @Lazy
  private final PasswordEncoder passwordEncoder;

  @Override
  public Customer findCustomerById(Long id) {
    return customerRepository.findById(id).orElse(null);
  }

  @Override
  public Optional<Customer> findCustomerByEmail(String email) {
    return customerRepository.findCustomerByEmail(email);
  }

  @Override
  public List<Customer> findAllCustomerList() {
    return customerRepository.findAll();
  }

  @Override
  public Customer registerCustomer(Customer customer) {
    Customer newCustomer = new Customer(
            customer.getName(),
            customer.getEmail(),
            passwordEncoder.encode(customer.getPassword()),
            "CUSTOMER");
    return customerRepository.save(newCustomer);
  }

  @Override
  public boolean checkEmail(String email) {
    return customerRepository.existsByEmail(email);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    final Optional<Customer> customer = customerRepository.findCustomerByEmail(email);
    if(customer.get().getEmail().isEmpty()) throw new UsernameNotFoundException("Invalid username or password");
    return new User(
            customer.get().getEmail(),
            customer.get().getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + customer.get().getRole().toString())));
  }
}
