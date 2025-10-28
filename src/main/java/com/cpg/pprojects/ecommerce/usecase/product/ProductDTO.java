package com.cpg.pprojects.ecommerce.usecase.product;

import com.cpg.pprojects.ecommerce.domain.product.model.Product;

public class ProductDTO {
    private Long idProduct;
    private String productName;
    private String image;
    private String description;
    private Integer quantity;
    private double price;
    private double discount;
    private double specialPrice;

    public ProductDTO() {
    }

    public ProductDTO(Long idProduct, String productName, String image, String description,
                      Integer quantity, double price, double discount, double specialPrice) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.image = image;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.specialPrice = specialPrice;
    }

    public ProductDTO(Product product){
        this.idProduct = product.getIdProduct();
        this.productName = product.getProductName();
        this.image = product.getImage();
        this.description = product.getDescription();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.discount = product.getDiscount();
        this.specialPrice = product.getSpecialPrice();
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(double specialPrice) {
        this.specialPrice = specialPrice;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "idProduct=" + idProduct +
                ", productName='" + productName + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", discount=" + discount +
                ", specialPrice=" + specialPrice +
                '}';
    }
}

