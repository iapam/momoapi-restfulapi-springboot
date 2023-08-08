package com.example.EcormerceApp.TryCormerce.Controllers;

import com.example.EcormerceApp.TryCormerce.Request.RegistrationRequest;
import com.example.EcormerceApp.TryCormerce.Service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/registration")
@AllArgsConstructor
public class AppUserController {
    private final RegistrationService registrationService;
    @ResponseBody
    @PostMapping("/register_admin")
    public String register(@RequestBody RegistrationRequest request){

        return  registrationService.register(request);
    }
}
