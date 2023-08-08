package com.example.EcormerceApp.TryCormerce.Service;

import com.example.EcormerceApp.TryCormerce.Controllers.ProductController;
import com.example.EcormerceApp.TryCormerce.Model.Product;
import com.example.EcormerceApp.TryCormerce.ProductOperations.Opertions;
import com.example.EcormerceApp.TryCormerce.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService implements Opertions {
    private final ProductRepository productRepository;
    @Override
    public String saveProduct(Product product) {
      productRepository.save(product);
        return "Product Saved";
    }
    public List<Product> getAllProduct(){
       List< Product> products=  productRepository.findAll();
        return products;
    }

    @Override
    public String deleteProduct(Long id) {

        return null;
    }

    @Override
    public Product BuyNow(Long id) {

        return  productRepository.findById(id).orElseThrow(()->
                new IllegalStateException("Product not found"));
    }
}
