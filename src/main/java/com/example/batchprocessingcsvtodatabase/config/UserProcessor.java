package com.example.batchprocessingcsvtodatabase.config;

import com.example.batchprocessingcsvtodatabase.model.Gender;
import com.example.batchprocessingcsvtodatabase.model.User;
import com.example.batchprocessingcsvtodatabase.model.UserInput;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class UserProcessor implements ItemProcessor<UserInput, User> {


    @Override
    public User process(UserInput userInput) throws Exception {

        User user = User.builder()
                .personId(UUID.fromString(userInput.getPersonId()))
                .firstName(userInput.getFirstName())
                .lastName(userInput.getLastName())
                .email(userInput.getEmail())
                .country(userInput.getCountry())
                .birthday(localDateTimeFormat(userInput.getBirthday()))
                .gender(userInput.getGender().equals("Male") ? Gender.MALE : Gender.FEMALE)
                .age(Period.between(localDateTimeFormat(userInput.getBirthday()), LocalDate.now()).getYears())
                .build();

        return user;
    }

    private LocalDate  localDateTimeFormat(String birthday) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime formatDateTime = LocalDateTime.parse(birthday, formatter);

        return formatDateTime.toLocalDate();
    }
}
