package com.omar.validation.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User {

    @Size(min = 3,max = 50) //Anotation to limit to max 50 chars and min 3
    private String name;

    @NotBlank //No nulls
    @Email(message = "Ingrese el correo en formarto email")
    private String email;

    @NotBlank
    @Size(min = 5,max = 15)
    private String password;

    @NotBlank
    private String gender;

    @Size(min = 5,max = 100)
    private String note;

    @AssertTrue //Should be always true
    private boolean marriage;

    @DateTimeFormat(pattern = "yyyy-mm-dd") //Date format
    private Date birthday;

    @NotBlank
    private String profession;

    @Min(value = 1000) //Set min and max value
    @Max(value = 200000)
    private long income;

}
