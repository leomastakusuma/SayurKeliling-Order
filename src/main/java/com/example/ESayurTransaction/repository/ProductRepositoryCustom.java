package com.example.ESayurTransaction.repository;

import com.example.ESayurTransaction.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepositoryCustom {


    @Query(value="select *  from product p where p.id_product =:idProduct", nativeQuery=true)
    Product getByIDs(@Param("idProduct") Long idProduct);


}
