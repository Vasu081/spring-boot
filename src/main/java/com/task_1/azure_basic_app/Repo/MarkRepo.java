package com.task_1.azure_basic_app.Repo;


import com.task_1.azure_basic_app.Models.Users;
import com.task_1.azure_basic_app.Models.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarkRepo extends JpaRepository<Marks,Long>{
    @Query("SELECT m FROM Marks m WHERE m.students.userId = :userId")
    List<Marks> findByUserId(@Param("userId") Long userId);

}
