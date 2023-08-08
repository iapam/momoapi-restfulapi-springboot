package com.example.EcormerceApp.TryCormerce.Controllers;

import com.example.EcormerceApp.TryCormerce.Model.Product;
import com.example.EcormerceApp.TryCormerce.PaymentSystem.PaymentGateWay;
import com.example.EcormerceApp.TryCormerce.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ActionController {
    private final ProductService productService;
    @GetMapping("/")
    public String indexPage(Model model){
        List<Product> products=productService.getAllProduct();
        model.addAttribute("product",products);
        return "index";
    }
}
