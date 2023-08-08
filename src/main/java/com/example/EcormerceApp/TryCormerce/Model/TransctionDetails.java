package com.example.EcormerceApp.TryCormerce.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransctionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
            @SequenceGenerator(name="payment_sequence",sequenceName = "payment_sequence",allocationSize = 1)

    Integer id;
    private BigInteger transactionid;
    private BigDecimal amount;
   private LocalDateTime paymentDate;
   private String paymentStatus;
   private String paymentPlatfform;
   private String paymentNumber;
  @ManyToOne
   @JoinColumn(nullable = false,name="payment_sequence")
   private Cart orderid;



    public TransctionDetails(BigInteger transactionid,
                             BigDecimal amount,
                             LocalDateTime paymentDate,
                             String paymentStatus,
                             String paymentPlatfform,
                             String paymentNumber,
                             Cart orderid
    ) {
        this.transactionid = transactionid;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.paymentPlatfform = paymentPlatfform;
        this.paymentNumber = paymentNumber;
        this.orderid = orderid;
    }
}
