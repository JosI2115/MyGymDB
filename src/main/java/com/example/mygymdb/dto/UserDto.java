package com.example.mygymdb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    @NotBlank(message = "Nombre vacio")
    private String name;
    @NotBlank(message = "Apellido vacio")
    private String lastName;
    @NotBlank(message = "Email vacio")
    private String email;
    @NotBlank(message = "Password vacio")
    private String password;
    @NotBlank(message = "Rol vacio")
    private String role;

}
