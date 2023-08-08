package com.example.EcormerceApp.TryCormerce.Service;

import com.example.EcormerceApp.TryCormerce.Model.Cart;
import com.example.EcormerceApp.TryCormerce.Model.TransctionDetails;
import com.example.EcormerceApp.TryCormerce.Repository.CartRepository;
import com.example.EcormerceApp.TryCormerce.Request.OrderRequest;
import com.example.EcormerceApp.TryCormerce.Request.PaymentRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class OrderService {
    private final CartRepository repository;
    private final PaymentService paymentService;

    public void order(OrderRequest request,PaymentRequest paymentRequest){

        Cart cart =new Cart(
                request.getFirstName(),
                request.getLastName(),
                request.getAddress(),
                request.getContactNumber(),
                request.getRegion(),
                request.getTown(),
                request.getPaymentNumber(),
                request.getTax(),
                request.getPrice(),
                request.getTotal(),
                request.getQuantity(),
                request.getProductName());
        repository.save(cart);
        TransctionDetails details=new TransctionDetails(
                paymentRequest.getTransactionid(),
                paymentRequest.getAmount(),
                LocalDateTime.now(),
                paymentRequest.getPaymentStatus(),
                paymentRequest.getPaymentNumber(),
                paymentRequest.getPaymentPlatfform(),
                cart
        );

        paymentService.makePayment(details);

    }
}
