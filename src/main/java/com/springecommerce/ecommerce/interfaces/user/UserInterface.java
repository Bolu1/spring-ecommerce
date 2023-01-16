package com.springecommerce.ecommerce.interfaces.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInterface {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
