package com.example.ESayurTransaction.controller;

import com.example.ESayurTransaction.Form.OrderForm;
import com.example.ESayurTransaction.model.OrderList;
import com.example.ESayurTransaction.model.Product;
import com.example.ESayurTransaction.model.Search;
import com.example.ESayurTransaction.model.TransaksiList;
import com.example.ESayurTransaction.repository.ProductRepository;
import com.example.ESayurTransaction.repository.TransaksiListRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Api(tags = "Order ")
@RequestMapping("/api/order")
public class OrderController {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    TransaksiListRepository transaksiListRepository;

    @Autowired
    ProductRepository productRepository;

    @ApiOperation("View List OrderForm by Pembeli")
    @GetMapping("/user/{idUser}")
    public List<TransaksiList> listOrderPembeli(@PathVariable("idUser") Long idUser) {
        List<TransaksiList> data = transaksiListRepository.getByUser(idUser);
        return data;
    }


    @ApiOperation("View List OrderForm by Grobak")
    @GetMapping("/grobak/{idGrobak}")
    public List<OrderList> listOrderGrobak(@PathVariable("idGrobak") Long idGrobak) {
        return  transaksiListRepository.listPesananByGrobak(idGrobak);
    }


    @ApiOperation("Create OrderForm ")
    @PostMapping("/")
    public TransaksiList createOrder(@RequestBody OrderForm orderForm) {

        Product productData = productRepository.getByIDs(orderForm.getIdProduct());
        if(productData ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            TransaksiList transaksiList = new TransaksiList();
            transaksiList.setIdProduct(orderForm.getIdProduct());
            transaksiList.setIdUser(orderForm.getIdUser());
            transaksiList.setQty(orderForm.getQty());

            transaksiList.setPrice(productData.getPrice());
            transaksiList.setProductName(productData.getProductName());
            transaksiList.setIdGrobak(productData.getIdUser());

            long total = Integer.valueOf(productData.getPrice()) * orderForm.getQty();
            transaksiList.setTotalPrice(String.valueOf(total));
            return transaksiListRepository.save(transaksiList);
        }
    }

    @ApiOperation("Delete OrderForm")
    @DeleteMapping("/{idOrder}")
    public ResponseEntity<?> delete(@PathVariable(value = "idOrder") Long idOrder) {
        TransaksiList transaksiList = transaksiListRepository.getById(idOrder);
        if(transaksiList ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            transaksiListRepository.deleteById(idOrder);
            return ResponseEntity.ok().build();
        }
    }

    @ApiOperation("Delete OrderForm")
    @DeleteMapping("/grobak/done/{idOrder}")
    public ResponseEntity<?> deleteOrder(@PathVariable(value = "idOrder") Long idOrder) {
        List<TransaksiList> transaksiList = transaksiListRepository.getByUser(idOrder);
        if(transaksiList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            transaksiListRepository.deleteByIdUser(idOrder);
            return ResponseEntity.ok().build();
        }
    }

    @ApiOperation("View List OrderForm by Pembeli")
    @GetMapping("/search")
    public List<Search> searching(@RequestParam(name="pembeli",required = false) String pembeli,@RequestParam(name = "grobak",required = false) String grobak,@RequestParam(name="product",required = false) String product,@RequestParam(name = "kategori",required = false) String kategori) {
        List<Search> searches =  transaksiListRepository.searchTransaksi(product, pembeli, grobak, kategori);
        if(pembeli ==null    && grobak ==null && product ==null && kategori ==null){
            return  transaksiListRepository.allTraksaksi();
        }
        return searches;
    }
}