package com.example.EcormerceApp.TryCormerce.Repository;

import com.example.EcormerceApp.TryCormerce.Model.TransctionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<TransctionDetails,Integer> {
}
