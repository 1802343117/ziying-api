package com.example.ziying.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddUserDto {

    @NotNull(message = "password 不能为空")
    private String password;
    @NotNull(message = "verifyCode 不能为空")
    private String verifyCode;
    @NotNull(message = "email 不能为空")
    private String email;
    @NotNull(message = "phoneNumber 不能为空")
    private String phoneNumber;

}
