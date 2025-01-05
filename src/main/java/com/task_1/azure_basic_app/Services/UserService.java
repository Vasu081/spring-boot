package com.task_1.azure_basic_app.Services;


import com.task_1.azure_basic_app.DTO.MarksDTO;
import com.task_1.azure_basic_app.DTO.UsersDTO;
import com.task_1.azure_basic_app.Models.Marks;
import com.task_1.azure_basic_app.Repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.task_1.azure_basic_app.Models.Users;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
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


public UsersDTO getUserById(Long id)
{

    if(userRepo.existsById(id))

    {   Users user=userRepo.findById(id).get();
        return (UsersDTO.convertToDTO(user));
    }
     throw new RuntimeException("User not found with ID "+id) ;
}

public String deleteById(Long id)
{
    if(userRepo.existsById(id))
    {
        userRepo.deleteById(id);
        return "deleted";
    }
    else {

        throw new RuntimeException("User not found with ID "+id) ;
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

        throw new RuntimeException("User not found with ID "+id) ;
    }

}
    public List<UsersDTO> getAllUsers() {
        List<Users> users = userRepo.findAll(); // Use a `findAllWithMarks` query if necessary
        return users.stream().map(UsersDTO::convertToDTO).collect(Collectors.toList());
    }



}

