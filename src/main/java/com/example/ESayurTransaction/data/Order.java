package com.example.ESayurTransaction.data;

import lombok.Data;

@Data
public class Order {
    private Long idUser;

    private Long totalBelanja;

    private Long totalPrice;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long gettotalBelanja() {
        return totalBelanja;
    }

    public void setTotalBelanja(Long totalBelanja) {
        this.totalBelanja = totalBelanja;
    }

    public Long gettotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
