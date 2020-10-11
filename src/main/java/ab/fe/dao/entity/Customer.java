package ab.fe.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
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
}
