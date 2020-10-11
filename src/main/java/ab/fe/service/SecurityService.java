package ab.fe.service;

import ab.fe.dao.entity.Customer;
import org.springframework.security.core.userdetails.User;

public interface SecurityService {
  Customer findLoggedUser();

  User findLoggedUserDetails();
}
