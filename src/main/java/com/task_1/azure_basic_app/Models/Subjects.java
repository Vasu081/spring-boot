package com.task_1.azure_basic_app.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "subjects")
@Getter
@Setter
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

private long subject_code;
    private String subject_name;

    @OneToMany(mappedBy = "subjects")
//    @JoinColumn(name = "marks_subject" ,referencedColumnName = "Id")
    private List<Marks> marks;


}
