package com.example.EcormerceApp.TryCormerce.Security.Config;
import com.example.EcormerceApp.TryCormerce.Security.PasswordEnco;
import com.example.EcormerceApp.TryCormerce.Service.AdminUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private final PasswordEnco passwordEnco;
    private final AdminUserService adminUserService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests().antMatchers("/admin/**")
                .hasAuthority("ADMIN")
                .antMatchers("add_product","/api/registration/**","/","/admin/buy_now/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return http.build();
    }
     @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web)->web.ignoring().antMatchers("/images/**").antMatchers("/css/**").
                antMatchers("/js/**");
    }

    protected AuthenticationManagerBuilder authenticationManagerBuilder(AuthenticationManagerBuilder auth){
      return auth.authenticationProvider(authenticationProvider());
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEnco.passwordEncoder());
        provider.setUserDetailsService(adminUserService);
        return provider;
    }
}
