package com.example.ESayurTransaction.repository;
import com.example.ESayurTransaction.model.TransaksiList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TransaksiListRepository extends CrudRepository<TransaksiList,Long>,TransaksiListRepositoryCustom {

  int deleteByIdUser(Long idUser);

}
