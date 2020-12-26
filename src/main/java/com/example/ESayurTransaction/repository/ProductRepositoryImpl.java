package com.example.ESayurTransaction.repository;
import com.example.ESayurTransaction.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


public class ProductRepositoryImpl implements  ProductRepositoryCustom {


    @Override
    public Product getByIDs(Long idProduct) {
        return null;
    }


}
