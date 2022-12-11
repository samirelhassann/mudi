package br.com.beyond.mvc.mudi.repository;

import br.com.beyond.mvc.mudi.model.OrderStatus;
import br.com.beyond.mvc.mudi.model.ProductOrders;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrdersRepository extends JpaRepository<ProductOrders, Long> {

  @Cacheable("books")
  List<ProductOrders> findByStatus(OrderStatus status, Pageable pageRequest);

  @Query("SELECT P FROM ProductOrders P JOIN P.user U WHERE U.username = :username")
  List<ProductOrders> findAllByUser(@Param("username") String userName);

  @Query(
      "SELECT P FROM ProductOrders P JOIN P.user U WHERE U.username = :username and P.status = :status")
  List<ProductOrders> findByStatusAndUser(
      @Param("status") OrderStatus status, @Param("username") String username);
}
