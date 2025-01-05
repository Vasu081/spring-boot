package com.task_1.azure_basic_app.Repo;


import com.task_1.azure_basic_app.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {

    @Query("SELECT u FROM Users u JOIN FETCH u.marks")
    List<Users> findAllWithMarks();



}
