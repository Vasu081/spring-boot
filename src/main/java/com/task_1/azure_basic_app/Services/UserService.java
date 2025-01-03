package com.task_1.azure_basic_app.Services;


import com.task_1.azure_basic_app.Repo.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.task_1.azure_basic_app.Models.Users;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public String createuser(Users user)
    {
            userRepo.saveAndFlush(user);
        System.out.println("user is "+user);
        return "save successfully";
    }
public List<Users> allUsers()
{

    return userRepo.findAll();
}

public Optional<Users> getUserById(Long id)
{


    return userRepo.findById(id);
}

public String deleteById(Long id)
{
    if(userRepo.existsById(id))
    {
        userRepo.deleteById(id);
        return "deleted";
    }
    else {

        return "user not found";
    }

}
public String updateUser(Long id,Users updatedUsers)
{
    Optional<Users> existingUserOptional=userRepo.findById(id);
    if(existingUserOptional.isPresent())
    {
        Users existingUser=existingUserOptional.get();
        if(updatedUsers.getFirst_name()!=null)
            existingUser.setFirst_name(updatedUsers.getFirst_name());
        if(updatedUsers.getLast_name()!=null)
            existingUser.setLast_name(updatedUsers.getLast_name());
        if(updatedUsers.getPhone_number()!=null)
            existingUser.setPhone_number(updatedUsers.getPhone_number());
        if(updatedUsers.getEmail()!=null)
            existingUser.setEmail(updatedUsers.getEmail());

        userRepo.save(existingUser);

        return "updated ";
    }

    else {

        return "user not found";
    }

}

}

