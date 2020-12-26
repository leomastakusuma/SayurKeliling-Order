package com.example.ESayurTransaction.repository;

import com.example.ESayurTransaction.model.Transaksi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransaksiRepositoryCustom {
    @Query(value="select *  from transaksi t where t.id_user =:idUser", nativeQuery=true)
    List<Transaksi> getByUser(@Param("idUser") Long idUser);


    @Query(value="select *  from transaksi t where t.id_transaksi =:idTransaki", nativeQuery=true)
    Transaksi  getById(@Param("idTransaki") Long idTransaki);

    @Query(value="delete  from transaksi t where t.id_transaksi =:idTransaki ", nativeQuery=true)
    Transaksi deleteByIDs(@Param("idTransaki") Long idTransaki);


}
