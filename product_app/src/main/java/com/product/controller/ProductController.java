package com.product.controller;

import com.product.entity.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;
   //POST method url - http://localhost:8081/addProduct
   /*{
       "name":"b",
           "quantity":2,
           "price":102
   }*/
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }
    //POST method url - http://localhost:8081/addProducts
   /* [
   {
        "name":"a",
                "quantity":1,
                "price":101
    },
    {
        "name":"b",
            "quantity":1,
            "price":102
    }
  ]*/
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }
    //GET method url - http://localhost:8081/products
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }
    //GET method url - http://localhost:8081/productById/1
    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }
    //GET method url - http://localhost:8081/product/a
    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }
    //PUT method url - http://localhost:8081/update
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }
    //DELETE method url - http://localhost:8081/delete/1
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
