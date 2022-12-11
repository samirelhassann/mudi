package br.com.beyond.mvc.mudi.controller;

import br.com.beyond.mvc.mudi.model.OrderStatus;
import br.com.beyond.mvc.mudi.model.ProductOrders;
import br.com.beyond.mvc.mudi.repository.ProductOrdersRepository;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

  @Autowired private ProductOrdersRepository productOrdersRepository;

  @GetMapping("order")
  public String home(Model model, Principal principal) {

    List<ProductOrders> productOrders = productOrdersRepository.findAllByUser(principal.getName());

    model.addAttribute("productOrders", productOrders);
    model.addAttribute("status", "all");
    return "user/home";
  }

  @GetMapping("order/{status}")
  public String pending(@PathVariable String status, Model model, Principal principal) {

    List<ProductOrders> productOrders =
        productOrdersRepository.findByStatusAndUser(
            OrderStatus.valueOf(status.toUpperCase()), principal.getName());

    model.addAttribute("productOrders", productOrders);
    model.addAttribute("status", status);
    return "user/home";
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public String onError() {
    return "redirect:/user/home";
  }
}
