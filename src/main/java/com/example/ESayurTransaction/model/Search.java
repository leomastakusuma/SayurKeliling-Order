package com.example.ESayurProduct.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public class Search {


  private String productName;

  private String kategori;

  private String pembeli;

  private String pembeli;
  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createdAt;

  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updatedAt;



  public Long getidProduct() {
    return idProduct;
  }

  public void setidProduct(Long id) {
    this.idProduct = idProduct;
  }

  public Long getIdUser() {
    return idUser;
  }

  public void setIdUser(Long idUser) {
    this.idUser = idUser;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getPrice() {
    return Price;
  }

  public void setPrice(String Price) {
    this.Price = Price;
  }

  public Long getIdKategori() {
    return idKategori;
  }

  public void setIdKategori(Long idKategori) {
    this.idKategori = idKategori;
  }



}

