package com.roelee.demo.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "mobileNumber", name = "uniqueMobileNumberConstraint"),
        @UniqueConstraint(columnNames = "email", name = "uniqueEmailConstraint")})
@Data
@ToString(of = {"id","firstName","lastName","bod","mobileNumber"})
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private LocalDate bod;

    @Column(nullable = false)
    private String mobileNumber;

    @Column(nullable = false)
    private String email;

    private String gender;

    public interface Gender {

        String MALE = "Male";
        String FEMALE = "Female";

    }


}
