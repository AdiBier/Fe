package ab.fe.dao.controller;

import ab.fe.dao.entity.Customer;
import ab.fe.service.CustomerServiceImpl;
import ab.fe.service.ValidationRegisterUserImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

  private final CustomerServiceImpl customerService;

  private final ValidationRegisterUserImpl validationRegisterUser;

  private final ObjectMapper mapper;

  @PostMapping("/create")
  public ResponseEntity<?> createNewCustomer(final Customer customer) {
    final ObjectNode node = mapper.createObjectNode();
    customerService.registerCustomer(customer);
    validationRegisterUser.checkExistingCustomer(node, customerService, customer);

    if (node.isEmpty()) {
      customerService.save(customer);
      return new ResponseEntity<>(node, HttpStatus.CREATED);
    }
    return new ResponseEntity<>(node, HttpStatus.UNPROCESSABLE_ENTITY);
  }
}
