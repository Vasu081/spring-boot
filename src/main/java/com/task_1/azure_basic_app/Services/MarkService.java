package com.task_1.azure_basic_app.Services;

import com.task_1.azure_basic_app.DTO.MarksDTO;
import com.task_1.azure_basic_app.Models.Marks;
import com.task_1.azure_basic_app.Models.Subjects;
import com.task_1.azure_basic_app.Models.Users;
import com.task_1.azure_basic_app.Repo.MarkRepo;
import com.task_1.azure_basic_app.Repo.SubjectRepo;
import com.task_1.azure_basic_app.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarkService {

    @Autowired
    private MarkRepo markRepo;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private SubjectRepo subjectRepo;




    public ResponseEntity<?> addMarks(Marks marks)
    {       if(checkIfUserHasMarksForSubject(marks.getStudents().getUserId(),marks.getSubjects().getSubject_code()))
         {
                return ResponseEntity.ok("Error:Same user id exist with same subject code");

            }
            else {


        try {
            if (subjectRepo.existsById(marks.getSubjects().getSubject_code())) {
                Subjects subjects = subjectRepo.findById(marks.getSubjects().getSubject_code()).get();
                marks.setSubjects(subjects);
                if (userRepo.existsById(marks.getStudents().getUserId())) {
                    Users students = userRepo.findById(marks.getStudents().getUserId()).get();

                    if (students.getRole().name().equals("TEACHER")) {
                        return ResponseEntity.ok("Error: user must be student");
                    } else {
                        marks.setStudents(students);
                    }
                } else {
                    return ResponseEntity.ok("user id not exist");
                }
            } else {


                return ResponseEntity.ok("Subject id not exist");
            }
            markRepo.save(marks);
            return ResponseEntity.ok("marks entry done");

        } catch (Exception e) {
            return ResponseEntity.ok(e);
        }
    }
    }
    public List<Marks> getAllMarks()
    {
        return markRepo.findAll();
    }
    public ResponseEntity<?> getMarksById(Long id)
    {
        if(markRepo.existsById(id))
        {
            return ResponseEntity.ok(markRepo.findById(id).get());
        }
        else {
            return ResponseEntity.ok("Marks ID is wrong");
        }
    }
    public ResponseEntity<?> UpdateMark(Long id,Marks marks)
    {
        if(markRepo.existsById(id))
        {
           if(checkIfUserHasMarksForSubject(marks.getStudents().getUserId(),marks.getSubjects().getSubject_code()))
            {
                                                    return ResponseEntity.ok("Error:Same user id exist with same subject code");
            }
           else {


               try {
                   Marks existingMark = markRepo.findById(id).get();
                   if (subjectRepo.existsById(marks.getSubjects().getSubject_code())) {
                       Subjects subjects = subjectRepo.findById(marks.getSubjects().getSubject_code()).get();
                       existingMark.setSubjects(subjects);
                       if (userRepo.existsById(marks.getStudents().getUserId())) {
                           Users students = userRepo.findById(marks.getStudents().getUserId()).get();

                           if (students.getRole().name().equals("TEACHER")) {
                               return ResponseEntity.ok("Error: user must be student");
                           } else {
                               existingMark.setStudents(students);
                           }
                       } else {
                           return ResponseEntity.ok("user id not exist");
                       }
                   } else {


                       return ResponseEntity.ok("Subject id not exist");
                   }
                   markRepo.save(existingMark);
                   return ResponseEntity.ok("marks entry done");

               } catch (Exception e) {
                   return ResponseEntity.ok(e);
               }
           }

                }
                            else{
                            return ResponseEntity.ok(marks.getId()+"mark ID not found");
                                }
    }


    public ResponseEntity<?> deleteMarkById(Long id)
    {
        if(markRepo.existsById(id))
        {
            markRepo.deleteById(id);
            return ResponseEntity.ok("mark entry deleted with id= "+id);
        }
        else {

            return ResponseEntity.ok("mark id not found");
        }
    }

    public boolean checkIfUserHasMarksForSubject(Long userId, Long subjectId) {
        // Fetch all Marks for the given userId
        List<Marks> userMarks = markRepo.findByUserId(userId);

        // Check if any of the user's marks match the subjectId
        return userMarks.stream()
                .anyMatch(mark -> mark.getSubjects().getSubject_code() == subjectId);
    }
    public List<MarksDTO> getAllMarkss() {
        List<Marks> marks = markRepo.findAll();
        return marks.stream()
                .map(MarksDTO::convertMarksToDTOWithUser)
                .collect(Collectors.toList());
    }


}
