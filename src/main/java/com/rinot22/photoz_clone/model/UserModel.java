package com.rinot22.photoz_clone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@RequiredArgsConstructor
@Table("USER")
public class UserModel {

    @Id
    private Integer id;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;


//    public UserModel(String userName, String email, String password) {
//        this.userName = userName;
//        this.email = email;
//        this.password = password;
//    }
}
