package ab.fe.service;

import ab.fe.dao.entity.Customer;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface ValidationRegisterUser {

  void checkExistingCustomer(
      ObjectNode node, CustomerServiceImpl customerService, Customer currentCustomer);
}
