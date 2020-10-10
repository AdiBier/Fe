package ab.fe.service;

import ab.fe.dao.entity.Customer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidationRegisterUserImpl implements ValidationRegisterUser {

  private final CustomerServiceImpl customerService;

  @Override
  public void checkExistingCustomer() {}

  private void checkExistingEmail(Customer customer, ObjectNode node) {
    if (customerService.checkEmail(customer.getEmail())) {
      node.put("email", "The given e-mail already exists");
    }
  }

  private void checkName(Customer customer, ObjectNode node){
    if(customer.getName() == null)
      node.put("name", "The name parameter is required.");
  }
}
