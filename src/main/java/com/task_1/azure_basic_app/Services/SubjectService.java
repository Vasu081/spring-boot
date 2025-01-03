package com.task_1.azure_basic_app.Services;


import com.task_1.azure_basic_app.Models.Subjects;
import com.task_1.azure_basic_app.Repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepo subjectRepo;

    public String saveSubject(Subjects subjects) {
        subjectRepo.save(subjects);
        return "subject added";
    }

    public List<Subjects> getAllSubject() {
        return subjectRepo.findAll();
    }

    public ResponseEntity<?> getSubjectById(Long id) {
        if (subjectRepo.existsById(id)) {


            return ResponseEntity.ok(subjectRepo.findById(id).get());
        } else {


           return ResponseEntity.ok("Subject not found ");
        }
    }

    public ResponseEntity<?> updateSubjectById(Long id, Subjects updatedSubject) {
        if (subjectRepo.existsById(id)) {
            Subjects existingSubject = subjectRepo.findById(id).get();
            if (updatedSubject.getSubject_name() != null)
                existingSubject.setSubject_name(updatedSubject.getSubject_name());

            subjectRepo.save(existingSubject);
            return ResponseEntity.ok(" subject updated");
        } else {

            return ResponseEntity.ok("Subject not found");
        }

    }

    public ResponseEntity<?> deleteById(Long id)
    {
        if (subjectRepo.existsById(id)) {
            subjectRepo.deleteById(id);

            return ResponseEntity.ok("deleted successfully");
        } else {


            return ResponseEntity.ok("Subject not found ");
        }

    }

}
