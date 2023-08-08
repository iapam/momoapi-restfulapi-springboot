package com.example.EcormerceApp.TryCormerce.Controllers;

import com.example.EcormerceApp.TryCormerce.Model.AdminUser;
import com.example.EcormerceApp.TryCormerce.Model.Product;
import com.example.EcormerceApp.TryCormerce.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


@Controller
@AllArgsConstructor
@RequestMapping("admin/")
public class ProductController{
private final ProductService productService;
@GetMapping("admin_dashboard")
  public String postProduct(Model model)  {
       AdminUser user= (AdminUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

       model.addAttribute("appuser",user);


        return "adminPage";
  }
  @GetMapping("/add_product_ui")
  public String addProduct(){
    return "addproduct";
  }
  @ResponseBody
  @PostMapping("/add_product")
  public String postProduct(@RequestParam String pname,
                            @RequestParam double price,
                            @RequestParam MultipartFile image,
                            @RequestParam String category,
                            @RequestParam String description) throws Exception{
    String imgurl= image.getOriginalFilename();
   String upload="src/main/resources/static/images/"+imgurl;
   File file=new File(upload);
   FileOutputStream outputStream=new FileOutputStream(file);
      BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
      bufferedOutputStream.write(image.getBytes());
      Product product=new Product();
      product.setImgurl(imgurl);
      product.setPname(pname);
      product.setCategory(category);
      product.setDescription(description);
      product.setPrice(price);
    return productService.saveProduct(product);
  }
  @GetMapping("/buy_now/{getAid}")
  public String buy_Now(@PathVariable("getAid") Long aid,Model model){
     Product product=productService.BuyNow(aid);
      AdminUser user= (AdminUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

      model.addAttribute("user",user);
      model.addAttribute("product",product);
      double tax=0.2*product.getPrice();
      double total= product.getPrice()+tax;
      model.addAttribute("total",total);
      model.addAttribute("tax",tax);
return "Shopping";
  }
}
