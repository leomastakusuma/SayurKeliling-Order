package com.example.ESayurTransaction.repository;

import com.example.ESayurTransaction.model.TransaksiList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TransaksiListRepository extends JpaRepository<TransaksiList,Long>,TransaksiListRepositoryCustom {
}
