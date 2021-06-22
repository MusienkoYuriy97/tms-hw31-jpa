package com.teachmeskills.test.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class UserUpdateDto {
    private long id;
    private String username;
    private String name;
    private String password;
    private String street;
    private int home;
}
