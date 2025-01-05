package com.task_1.azure_basic_app.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    private long userId;
    @Column(name = "fName")
    private String first_name;
    @Column(name = "lName")
    private String last_name;

    private String email;
    @Column(name = "phoneNumber")
    private String phone_number;
    @Enumerated(EnumType.STRING)
    private Role role;



    public enum Role {
        STUDENT,
        TEACHER
    }

    @OneToMany(mappedBy = "students",fetch = FetchType.LAZY)

//    @JoinColumn(name = "marks_student" ,referencedColumnName = "Id")
    private List<Marks> marks;
}
