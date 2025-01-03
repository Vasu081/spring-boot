package com.task_1.azure_basic_app.Repo;


import com.task_1.azure_basic_app.Models.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subjects,Long> {
}
