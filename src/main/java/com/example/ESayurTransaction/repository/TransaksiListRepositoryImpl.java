package com.example.ESayurTransaction.repository;

import com.example.ESayurTransaction.model.OrderList;
import com.example.ESayurTransaction.model.Search;
import com.example.ESayurTransaction.model.TransaksiList;
import com.example.ESayurTransaction.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;


public class TransaksiListRepositoryImpl implements  TransaksiListRepositoryCustom{


    @Override
    public List<TransaksiList> getByUser(Long idUser) {
        return null;
    }
    @Override
    public TransaksiList getById(Long idTransaki) {
        return null;
    }
    @Override
    public List<OrderList> listPesananByGrobak(Long idGrobak) {
        return null;
    }

    @Override
    public List<Search> searchTransaksi(String product, String pembeli, String grobak, String kategori) {
        return null;
    }

    @Override
    public List<Search> allTraksaksi() {
        return null;
    }

}
