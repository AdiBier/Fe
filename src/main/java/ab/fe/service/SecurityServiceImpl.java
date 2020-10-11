package ab.fe.service;

import ab.fe.dao.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {

  private final CustomerServiceImpl customerService;

  @Override
  public Customer findLoggedUser() {
    final User user = findLoggedUserDetails();
    return user == null ? null : customerService.findByLogin(user.getUsername());
  }

  @Override
  public User findLoggedUserDetails() {
    Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return userDetails instanceof User ? (User) userDetails : null;
  }
}
