package com.product.service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
   //feature1 - save the only one product
    public Product saveProduct(Product product) {
        return repository.save(product);
    }
    //feature2 - save the multiple product
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }
    //feature3 - see the all product
    public List<Product> getProducts() {
        return repository.findAll();
    }
    //feature4 - see the product by required id
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }
    //feature5 - see the product by required name
    public Product getProductByName(String name) {
        return repository.findByName(name);
    }
    //feature6 - delete the product by id
    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed" + id;
    }
    //feature7 - update the product by id
    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }


}
