package br.com.beyond.mvc.mudi.dto;

import br.com.beyond.mvc.mudi.model.OrderStatus;
import br.com.beyond.mvc.mudi.model.ProductOrders;
import javax.validation.constraints.NotBlank;

public class NewOrderRequest {

  @NotBlank private String productName;

  @NotBlank private String productUrl;

  @NotBlank private String productImage;
  private String productDescription;

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductUrl() {
    return productUrl;
  }

  public void setProductUrl(String productUrl) {
    this.productUrl = productUrl;
  }

  public String getProductImage() {
    return productImage;
  }

  public void setProductImage(String productImage) {
    this.productImage = productImage;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public ProductOrders toOrder() {
    ProductOrders productOrders = new ProductOrders();
    productOrders.setProductName(this.productName);
    productOrders.setDescription(this.productDescription);
    productOrders.setProductUrl(this.productUrl);
    productOrders.setImageUrl(this.productImage);
    productOrders.setStatus(OrderStatus.PENDING);

    return productOrders;
  }
}
