package com.task_1.azure_basic_app.Models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Marks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Marks {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long Id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "userId", nullable = false)
    private Users students;

    private int mark;
    @ManyToOne
    @JoinColumn(name="subject_id",referencedColumnName = "subject_code",nullable = false)
    private Subjects subjects;

}
