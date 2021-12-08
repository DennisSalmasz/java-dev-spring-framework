package com.cyber.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Mentor {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private boolean graduated;
    private String batch;
    private String company;


}
