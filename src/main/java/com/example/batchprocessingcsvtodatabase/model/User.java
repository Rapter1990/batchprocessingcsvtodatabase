package com.example.batchprocessingcsvtodatabase.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`user`")
@Builder
public class User extends BaseEntity{

    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID personId;

    private String firstName;
    private String lastName;
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String country;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;

    private int age;
}
