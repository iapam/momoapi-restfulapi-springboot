package com.example.EcormerceApp.TryCormerce.Model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AdminUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "app_user_s")
    @SequenceGenerator(name="app_user_s",sequenceName = "app_user_s",allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    private  AppUserRole appUserRole;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    public AdminUser(AppUserRole appUserRole, String email, String firstName, String lastName, String password) {
        this.appUserRole = appUserRole;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       SimpleGrantedAuthority authority=new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
