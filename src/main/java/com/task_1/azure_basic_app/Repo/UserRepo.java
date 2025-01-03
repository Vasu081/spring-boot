package com.task_1.azure_basic_app.Repo;


import com.task_1.azure_basic_app.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {




}
