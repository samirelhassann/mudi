package br.com.beyond.mvc.mudi.api;

import br.com.beyond.mvc.mudi.model.OrderStatus;
import br.com.beyond.mvc.mudi.model.ProductOrders;
import br.com.beyond.mvc.mudi.repository.ProductOrdersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrdersRest {

  @Autowired private ProductOrdersRepository productOrdersRepository;

  public OrdersRest(ProductOrdersRepository productOrdersRepository) {
    this.productOrdersRepository = productOrdersRepository;
  }

  @GetMapping("/pending")
  public List<ProductOrders> getOrderPendingOrders() {
    return productOrdersRepository.findByStatus(
        OrderStatus.DELIVERED, PageRequest.of(0, 20, Sort.by("id").descending()));
  }
}
