package com.example.EcormerceApp.TryCormerce.Repository;

import com.example.EcormerceApp.TryCormerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
