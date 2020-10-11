package ab.fe.service;

import ab.fe.dao.entity.Customer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidationRegisterUserImpl implements ValidationRegisterUser {

  private final CustomerServiceImpl customerService;

  public static final int NAME_MIN_LENGTH = 1;

  public static final int NAME_MAX_LENGTH = 30;

  @Override
  public void checkExistingCustomer(
      ObjectNode node, CustomerServiceImpl customerService, Customer currentCustomer) {
    checkName(currentCustomer, node);
    checkExistingEmail(currentCustomer, node);
  }

  private void checkExistingEmail(Customer customer, ObjectNode node) {
    if (customerService.checkEmail(customer.getEmail())) {
      node.put("email", "The given e-mail already exists");
    }
  }

  private void checkName(Customer customer, ObjectNode node) {
    if (customer.getName() == null) node.put("name", "The name parameter is required.");
    if (customer.getName().length() < NAME_MIN_LENGTH)
      node.put("name", "The name parameter too short. Should contain no less that 2 characters.");
    if (customer.getName().length() > NAME_MAX_LENGTH)
      node.put("name", "The name parameter too long. Should contain no more that 30 characters.");
  }
}
