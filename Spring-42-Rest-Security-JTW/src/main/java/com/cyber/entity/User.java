package com.cyber.entity;

import com.cyber.enums.UserRole;
import com.cyber.enums.UserState;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@Where(clause = "is_deleted=false")
public class User extends BaseEntity {

    //this entity is for DB verification

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private Boolean isVerified;

    @Enumerated(EnumType.STRING)
    private UserState state;
}
