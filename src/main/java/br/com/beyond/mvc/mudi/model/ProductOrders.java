package br.com.beyond.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class ProductOrders {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String productName;
  private BigDecimal negotiatedValue;
  private LocalDate deliveryDate;
  private String productUrl;
  private String imageUrl;
  private String description;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  public String getProductName() {
    return productName;
  }

  public Long getId() {
    return id;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public BigDecimal getNegotiatedValue() {
    return negotiatedValue;
  }

  public void setNegotiatedValue(BigDecimal negotiatedValue) {
    this.negotiatedValue = negotiatedValue;
  }

  public LocalDate getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(LocalDate deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public String getProductUrl() {
    return productUrl;
  }

  public void setProductUrl(String productUrl) {
    this.productUrl = productUrl;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
