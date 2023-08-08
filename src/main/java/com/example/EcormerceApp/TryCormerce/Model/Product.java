package com.example.EcormerceApp.TryCormerce.Model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_s")
    @SequenceGenerator(name="product_s",sequenceName = "product_s",allocationSize = 1)
    @Id
    private Long aid;
    private String pname;
    private double price;
    private String Description;
    private String imgurl;
    private String Category;

}
