package com.example.EcormerceApp.TryCormerce.Service;

import com.example.EcormerceApp.TryCormerce.Model.TransctionDetails;
import com.example.EcormerceApp.TryCormerce.Repository.PaymentRepository;
import com.example.EcormerceApp.TryCormerce.Request.PaymentRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;


    public void makePayment(TransctionDetails details){

        paymentRepository.save(details);
    }
}
