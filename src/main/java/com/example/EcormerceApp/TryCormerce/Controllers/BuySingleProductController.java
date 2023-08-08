package com.example.EcormerceApp.TryCormerce.Controllers;

import com.example.EcormerceApp.TryCormerce.Model.Product;
import com.example.EcormerceApp.TryCormerce.Model.TransctionDetails;
import com.example.EcormerceApp.TryCormerce.PaymentSystem.PaymentGateWay;
import com.example.EcormerceApp.TryCormerce.Request.OrderRequest;
import com.example.EcormerceApp.TryCormerce.Request.PaymentRequest;
import com.example.EcormerceApp.TryCormerce.Service.OrderService;
import com.example.EcormerceApp.TryCormerce.Service.PaymentService;
import com.example.EcormerceApp.TryCormerce.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
public class BuySingleProductController {
    private final ProductService productService;
    private final OrderService cartService;


    @PostMapping("/continueShopping")
    public String buy(
            @RequestParam("firstName") String firstName,
                    @RequestParam("lastName") String lastName,
                    @RequestParam("address") String address,
                    @RequestParam("contactNumber") String contactNumber,
                    @RequestParam("region") String region,
                    @RequestParam("town") String town,
                    @RequestParam("paymentNumber") String paymentNumber,
                    @RequestParam("pid") Long pid,
                    @RequestParam("uid") String uid){
        PaymentRequest paymentRequest=new PaymentRequest();
        Product product=productService.BuyNow(pid);

        double price = product.getPrice();
        double tax=price*0.2;
        double total= product.getPrice()+tax;
        String productName= product.getPname();
        OrderRequest orderRequest=new OrderRequest();
        orderRequest.setFirstName(firstName);
        orderRequest.setLastName(lastName);
        orderRequest.setAddress(address);
        orderRequest.setContactNumber(contactNumber);
        orderRequest.setRegion(region);
        orderRequest.setTown(town);
        orderRequest.setPaymentNumber(paymentNumber);
        orderRequest.setPrice(price);
        orderRequest.setTax(tax);
        orderRequest.setTotal(total);
        orderRequest.setQuantity(1);
        orderRequest.setProductName(productName);
        int tra= (int) Math.random()*100000;
        System.out.println("The number is"+paymentNumber);
        paymentRequest.setPaymentNumber(paymentNumber);
        paymentRequest.setPaymentDate(LocalDateTime.now());
        paymentRequest.setAmount(BigDecimal.valueOf(price));
        paymentRequest.setTransactionid(BigInteger.valueOf(tra));
        paymentRequest.setPaymentPlatfform("Mobile Money");
        PaymentGateWay gateWay=new PaymentGateWay();
        System.out.println("transaction "+tra);
     //  String paymentStatus= gateWay.Payment(paymentRequest.getAmount(),paymentRequest.getTransactionid(),paymentRequest.getPaymentNumber());
     //  System.out.println(paymentStatus);

        cartService.order(orderRequest,paymentRequest);
        return "redirect:/";
    }
}
