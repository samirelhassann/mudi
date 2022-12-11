package br.com.beyond.mvc.mudi.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id private String username;
  private String password;
  private Boolean enabled;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
  private List<ProductOrders> orders;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }
}
