package com.task_1.azure_basic_app.DTO;


import com.task_1.azure_basic_app.Models.Marks;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MarksDTO {


    private long id;
    private int mark;
    private String subjectName;
    private UserSummaryDTO user;

    public static MarksDTO convertMarksToDTO(Marks marks) {
        MarksDTO marksDTO = new MarksDTO();
        marksDTO.setId(marks.getId());
        marksDTO.setMark(marks.getMark());
        marksDTO.setSubjectName(marks.getSubjects().getSubject_name()); // Assuming getSubjectName() exists
        return marksDTO;
    }

    public static MarksDTO convertMarksToDTOWithUser(Marks mark) {
        MarksDTO markDTO = new MarksDTO();
        markDTO.setId(mark.getId());
        markDTO.setMark(mark.getMark());
        markDTO.setSubjectName(mark.getSubjects().getSubject_name());

        UserSummaryDTO userSummaryDTO = new UserSummaryDTO();
        userSummaryDTO.setUserId(mark.getStudents().getUserId());
        userSummaryDTO.setFirstName(mark.getStudents().getFirst_name());
        userSummaryDTO.setLastName(mark.getStudents().getLast_name());
        markDTO.setUser(userSummaryDTO);

        return markDTO;
    }
}
