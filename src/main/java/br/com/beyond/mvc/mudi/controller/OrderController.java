package br.com.beyond.mvc.mudi.controller;

import br.com.beyond.mvc.mudi.dto.NewOrderRequest;
import br.com.beyond.mvc.mudi.model.ProductOrders;
import br.com.beyond.mvc.mudi.model.User;
import br.com.beyond.mvc.mudi.repository.ProductOrdersRepository;
import br.com.beyond.mvc.mudi.repository.UserRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("productOrders")
public class OrderController {

  @Autowired private ProductOrdersRepository productOrdersRepository;

  @Autowired private UserRepository userRepository;

  @GetMapping("form")
  public String productForm(NewOrderRequest request) {
    return "order/productForm";
  }

  @PostMapping("new")
  public String newOrder(@Valid NewOrderRequest request, BindingResult result) {

    if (result.hasErrors()) return "order/productForm";

    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    User user = userRepository.findByUsername(username);

    ProductOrders productOrders = request.toOrder();
    productOrders.setUser(user);
    productOrdersRepository.save(productOrders);

    return "redirect:/home";
  }

  @PostMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {

    productOrdersRepository.deleteById(id);
    return "redirect:/home";
  }
}
