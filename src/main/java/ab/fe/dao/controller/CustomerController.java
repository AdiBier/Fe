package ab.fe.dao.controller;

import ab.fe.dao.entity.Customer;
import ab.fe.service.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewCustomer(@RequestParam(name = "name", required = true) final String name,
                                               @RequestParam(name = "email", required = true) final String email,
                                               @RequestParam(name = "password", required = true) final String password){
        Customer customer

        return ResponseEntity<>();
    }
}
