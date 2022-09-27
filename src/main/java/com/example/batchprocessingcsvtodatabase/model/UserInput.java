package com.example.batchprocessingcsvtodatabase.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInput {

    private String personId;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String birthday;
    private int age;

}
