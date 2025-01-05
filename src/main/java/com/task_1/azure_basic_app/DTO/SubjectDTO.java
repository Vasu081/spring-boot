package com.task_1.azure_basic_app.DTO;


import com.task_1.azure_basic_app.Models.Subjects;
import lombok.Getter;
import lombok.Setter;
import java.util.stream.Collectors;
import java.util.List;

@Getter
@Setter
public class SubjectDTO {
    private long subjectId;
    private String subjectName;
    private List<MarksDTO> marks;

    public static SubjectDTO convertToSubjectDTO(Subjects subject) {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setSubjectId(subject.getSubject_code());
        subjectDTO.setSubjectName(subject.getSubject_name());

        // Convert List<Marks> to List<MarksDTO> with UserSummary
        List<MarksDTO> marksDTOList = subject.getMarks().stream()
                .map(MarksDTO::convertMarksToDTOWithUser)
                .collect(Collectors.toList());
        subjectDTO.setMarks(marksDTOList);

        return subjectDTO;
    }



}
