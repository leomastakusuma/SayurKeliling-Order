package com.example.ESayurTransaction.controller;

import com.example.ESayurTransaction.model.Product;
import com.example.ESayurTransaction.model.TransaksiList;
import com.example.ESayurTransaction.repository.ProductRepository;
import com.example.ESayurTransaction.repository.TransaksiListRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Api(tags = "Order")
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    TransaksiListRepository transaksiListRepository;
    
    @Autowired
    ProductRepository productRepository;

    @ApiOperation("View List Order by Pembeli")
    @GetMapping("/user/{idUser}")
    public List<TransaksiList> listOrderPembeli(@PathVariable("idUser") Long idUser) {
        List<TransaksiList> data = transaksiListRepository.getByUser(idUser);
        return data;
    }


    @ApiOperation("View List Order by Grobak")
    @GetMapping("/grobak/{idGrobak}")
    public List<Object> listOrderGrobak(@PathVariable("idGrobak") Long idGrobak) {
        return  transaksiListRepository.listPesananByGrobak(idGrobak);
    }


    @ApiOperation("Create Order ")
    @PostMapping("/")
    public TransaksiList createOrder(@RequestBody TransaksiList transaksiList) {

        Product productData = productRepository.getByIDs(transaksiList.getIdProduct());
        if(productData ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            transaksiList.setPrice(productData.getPrice());
            transaksiList.setIdProduct(productData.getidProduct());
            transaksiList.setProductName(productData.getProductName());
            transaksiList.setIdGrobak(productData.getIdUser());
            long total = Integer.valueOf(productData.getPrice()) * transaksiList.getQty();
            transaksiList.setTotalPrice(String.valueOf(total));
            return transaksiListRepository.save(transaksiList);
        }
    }

    @ApiOperation("Delete Order")
    @DeleteMapping("/{idOrder}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "idOrder") Long idOrder) {
        TransaksiList transaksiList = transaksiListRepository.getById(idOrder);
        if(transaksiList ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            transaksiListRepository.deleteById(idOrder);
            return ResponseEntity.ok().build();
        }
    }
}
