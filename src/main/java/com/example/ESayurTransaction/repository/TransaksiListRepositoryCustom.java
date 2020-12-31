package com.example.ESayurTransaction.repository;

import com.example.ESayurTransaction.model.OrderList;
import com.example.ESayurTransaction.model.Search;
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

    @Query(value="select   distinct (id_user) as idUser from transaksi_list t where t.id_grobak =:idGrobak ", nativeQuery=true)
    List<OrderList> listPesananByGrobak(Long idGrobak);

    @Query(value="SELECT tl.product_name as productName,kt.kategori,tl.qty,pembeli.full_name as pembeli, grobak.full_name as grobak  from transaksi_list tl \n"
        + "\tJOIN user pembeli ON pembeli.id_user = tl.id_user \n"
        + "\tJOIN product p on p.id_product = tl.id_product\n"
        + "\tJOIN kategori kt on kt.id_kategori = p.id_kategori\n"
        + "\tJOIN user grobak ON grobak.id_user = tl.id_grobak\n"
        + "WHERE tl.product_name LIKE %:product% OR pembeli.full_name LIKE %:pembeli% OR kt.kategori LIKE %:kategori% OR grobak.full_name LIKE %:grobak%\n"
        + "\n"
        + "and pembeli.level='pembeli'\n"
        + "and grobak.level = 'grobak'", nativeQuery=true)
    List<Search> searchTransaksi(String product,String pembeli,String grobak,String kategori);

    @Query(value="SELECT tl.product_name as productName,kt.kategori,tl.qty,pembeli.full_name as pembeli, grobak.full_name as grobak  from transaksi_list tl \n"
        + "\tJOIN user pembeli ON pembeli.id_user = tl.id_user \n"
        + "\tJOIN product p on p.id_product = tl.id_product\n"
        + "\tJOIN kategori kt on kt.id_kategori = p.id_kategori\n"
        + "\tJOIN user grobak ON grobak.id_user = tl.id_grobak\n"
        + "\tand pembeli.level='pembeli'\n"
        + "\tand grobak.level = 'grobak'", nativeQuery=true)
    List<Search> allTraksaksi();

}
