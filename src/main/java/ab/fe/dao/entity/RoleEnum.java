package ab.fe.dao.entity;

import lombok.Getter;

@Getter
public enum RoleEnum {
  ADMIN("ADMIN"),
  CUSTOMER("CUSTOMER");

  private String name;

  RoleEnum(String name) {
    this.name = name;
  }
}
