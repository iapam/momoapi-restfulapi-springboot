package com.example.EcormerceApp.TryCormerce.Request;

import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PaymentRequest {
    private  BigInteger transactionid;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private String paymentStatus;
    private String paymentPlatfform;
    private String paymentNumber;
}
