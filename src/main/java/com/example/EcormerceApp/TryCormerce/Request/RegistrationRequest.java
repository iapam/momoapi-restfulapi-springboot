package com.example.EcormerceApp.TryCormerce.Request;

import com.example.EcormerceApp.TryCormerce.Model.AppUserRole;
import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
    private final AppUserRole appUserRole;
}
