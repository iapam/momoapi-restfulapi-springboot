package com.example.EcormerceApp.TryCormerce.ProductOperations;

import com.example.EcormerceApp.TryCormerce.Model.Product;
import org.springframework.stereotype.Service;

@Service
public interface Opertions {
    public String saveProduct(Product product);
    public String deleteProduct(Long id);
    public Product BuyNow(Long id);
}
