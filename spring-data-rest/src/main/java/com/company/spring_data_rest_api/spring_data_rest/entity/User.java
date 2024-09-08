package com.company.spring_data_rest_api.spring_data_rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//lombok anotation to generate setter and getter method
@AllArgsConstructor//parameterized contructor
@NoArgsConstructor//default contructor
@Builder//builder pattern user entity to create object
@Entity
@Table(name = "users")
public class User {
    //add property and fields in user entity class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false)//provide map or column name of this fields
    private String firstName;
    @Column(name = "middle_name", nullable = false)//provide map or column name of this fields
    private String middleName;
    @Column(name = "last_name", nullable = false)//provide map or column name of this fields
    private String lastName;
    private String email;
}
