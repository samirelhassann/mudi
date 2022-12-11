package br.com.beyond.mvc.mudi.controller;

import br.com.beyond.mvc.mudi.model.OrderStatus;
import br.com.beyond.mvc.mudi.model.ProductOrders;
import br.com.beyond.mvc.mudi.repository.ProductOrdersRepository;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

  @Autowired private ProductOrdersRepository productOrdersRepository;

  @GetMapping
  public String home(Model model, Principal principal) {

    List<ProductOrders> productOrders =
        productOrdersRepository.findByStatus(
            OrderStatus.DELIVERED, PageRequest.of(0, 20, Sort.by("deliveryDate").descending()));

    model.addAttribute("productOrders", productOrders);
    model.addAttribute("status", "all");
    return "home";
  }
}
