package com.example.ESayurTransaction.controller;

import com.example.ESayurTransaction.model.Product;
import com.example.ESayurTransaction.model.Transaksi;
import com.example.ESayurTransaction.repository.ProductRepository;
import com.example.ESayurTransaction.repository.TransaksiRepository;
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
    TransaksiRepository transaksiRepository;

    @Autowired
    ProductRepository productRepository;

    @ApiOperation("View List Order")
    @GetMapping("/{idUser}")
    public List<Transaksi> listOrder(@PathVariable("idUser") Long idUser) {
        List<Transaksi> data = transaksiRepository.getByUser(idUser);
        return data;
    }

    @ApiOperation("Create Order ")
    @PostMapping("/")
    public Transaksi createOrder(@RequestBody Transaksi transaksi) {
        Product productData = productRepository.getByIDs(transaksi.getIdProduct());
        if(productData ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            transaksi.setPrice(productData.getPrice());
            transaksi.setIdProduct(productData.getidProduct());
            transaksi.setProductName(productData.getProductName());
            transaksi.setIdGrobak(productData.getIdUser());
            long total = Integer.valueOf(productData.getPrice()) * transaksi.getQty();
            transaksi.setTotalPrice(String.valueOf(total));
            return transaksiRepository.save(transaksi);
        }
    }

    @ApiOperation("Delete Order")
    @DeleteMapping("/{idOrder}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "idOrder") Long idOrder) {
        Transaksi transaksi = transaksiRepository.getById(idOrder);
        if(transaksi ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            transaksiRepository.deleteById(idOrder);
            return ResponseEntity.ok().build();
        }
    }
}
