package com.example.ESayurTransaction.repository;

import com.example.ESayurTransaction.model.TransaksiList;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TransaksiListRepositoryCustom {



    @Query(value="select *  from transaksi_list t where t.id_user =:idUser", nativeQuery=true)
    List<TransaksiList> getByUser(@Param("idUser") Long idUser);


    @Query(value="select *  from transaksi_list t where t.id_transaksi =:idTransaki", nativeQuery=true)
    TransaksiList getById(@Param("idTransaki") Long idTransaki);


    @Query(value="select  distinct (t.id_user) id_user from transaksi_list t where t.id_grobak =:idGrobak ", nativeQuery=true)
    List<Object> listPesananByGrobak(Long idGrobak);

}
