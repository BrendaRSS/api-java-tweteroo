package com.tweteroo.api.models;

import org.hibernate.validator.constraints.URL;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.tweteroo.api.dtos.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {

    public UserModel(UserDTO bodyDto){
        this.avatar = bodyDto.getAvatar();
        this.username = bodyDto.getUsername();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String avatar;

    @Column(nullable = false, length = 30, unique = true)
    private String username;
}
