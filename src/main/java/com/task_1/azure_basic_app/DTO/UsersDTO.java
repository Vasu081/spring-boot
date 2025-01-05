package com.task_1.azure_basic_app.DTO;


import com.task_1.azure_basic_app.Models.Users;
import com.task_1.azure_basic_app.DTO.MarksDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;



@Getter
@Setter
public class UsersDTO {

    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String role; // Enum as a String
    private List<MarksDTO> marks;

    public static UsersDTO convertToDTO(Users user) {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUserId(user.getUserId());
        usersDTO.setFirstName(user.getFirst_name());
        usersDTO.setLastName(user.getLast_name());
        usersDTO.setEmail(user.getEmail());
        usersDTO.setPhoneNumber(user.getPhone_number());
        usersDTO.setRole(user.getRole().name()); // Enum to String

        // Convert List<Marks> to List<MarksDTO>
        List<MarksDTO> marksDTOList = user.getMarks().stream().map(MarksDTO::convertMarksToDTO).collect(Collectors.toList());
        usersDTO.setMarks(marksDTOList);

        return usersDTO;
    }
}
