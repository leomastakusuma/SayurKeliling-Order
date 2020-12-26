package com.example.ESayurTransaction.repository;

import com.example.ESayurTransaction.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TransaksiRepository extends JpaRepository<Transaksi,Long>,TransaksiRepositoryCustom {
}
