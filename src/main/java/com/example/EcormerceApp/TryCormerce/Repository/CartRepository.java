package com.example.EcormerceApp.TryCormerce.Repository;

import com.example.EcormerceApp.TryCormerce.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {

}
