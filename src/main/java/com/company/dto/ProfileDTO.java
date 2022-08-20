package com.company.dto;

import com.company.enums.ProfileRole;
import com.company.enums.ProfileStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProfileDTO {

    private Integer id;

    @NotNull(message = "Name qani ?")
    private String name;

    @NotNull(message = "Surname qani ?")
    private String surname;

    @NotNull
    private String phone;

    @NotNull(message = "Email qani ?")
    private String email;

    @NotNull(message = "Password qani")
    private String password;

    private ProfileStatus status;

    private ProfileRole role;

    private Boolean visible;

    private LocalDateTime createdDate;

    private String jwt;
}