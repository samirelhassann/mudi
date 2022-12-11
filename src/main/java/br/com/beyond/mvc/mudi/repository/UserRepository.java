package br.com.beyond.mvc.mudi.repository;

import br.com.beyond.mvc.mudi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

  User findByUsername(String username);
}
