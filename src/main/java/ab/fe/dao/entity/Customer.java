package ab.fe.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Customer", uniqueConstraints = @UniqueConstraint(columnNames = {"Email"}))
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Customer_Id", nullable = false, unique = true, updatable = false)
  private Long customerId;

  @Column(name = "Name", nullable = false, length = 30)
  private String name;

  @Column(name = "Email", nullable = false, unique = true)
  private String email;

  @Column(name = "Password", nullable = false)
  private String password;

  @Column(name = "Role", nullable = false)
  private String role;

  public Customer(String name, String email, String password, String role) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
  }
}
