package com.task_1.azure_basic_app.Controller;

import com.task_1.azure_basic_app.DTO.SubjectDTO;
import com.task_1.azure_basic_app.Models.Subjects;
import com.task_1.azure_basic_app.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    @PostMapping
    public String addSubject(@RequestBody Subjects subjects)
    {
       return subjectService.saveSubject(subjects);
    }

    @GetMapping
    public List<SubjectDTO> getSubject()
    {
//        return subjectService.getAllSubject();
            return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubjectById(@PathVariable Long id)
    {

        return subjectService.getSubjectById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable Long id, @RequestBody Subjects subjects)
    {

        return subjectService.updateSubjectById(id,subjects);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable long id)
    {
        return subjectService.deleteById(id);
    }



}
