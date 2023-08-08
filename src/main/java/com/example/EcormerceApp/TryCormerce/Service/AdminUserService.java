package com.example.EcormerceApp.TryCormerce.Service;

import com.example.EcormerceApp.TryCormerce.Model.AdminUser;
import com.example.EcormerceApp.TryCormerce.Repository.AppUserRepository;
import com.example.EcormerceApp.TryCormerce.Security.PasswordEnco;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminUserService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final PasswordEnco passwordEnco;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).
                orElseThrow(()->new IllegalStateException("User with "+email+" does not exist"));
    }
    public String signUp(AdminUser adminUser){
        BCryptPasswordEncoder encoder=passwordEnco.passwordEncoder();
        String passencode=encoder.encode(adminUser.getPassword());
        adminUser.setPassword(passencode);
        appUserRepository.save(adminUser);
        return "successfully";
    }
}
