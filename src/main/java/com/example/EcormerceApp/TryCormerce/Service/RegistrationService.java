package com.example.EcormerceApp.TryCormerce.Service;

import com.example.EcormerceApp.TryCormerce.Model.AdminUser;
import com.example.EcormerceApp.TryCormerce.Model.AppUserRole;
import com.example.EcormerceApp.TryCormerce.Request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AdminUserService adminUserService;

    public String register(RegistrationRequest request){

        return adminUserService.signUp(new AdminUser(AppUserRole.ADMIN,
                request.getEmail(),request.getFirstName(),request.getLastName(),request.getPassword()
        ));
    }
}
