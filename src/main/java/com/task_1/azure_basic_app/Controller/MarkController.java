package com.task_1.azure_basic_app.Controller;


import com.task_1.azure_basic_app.Models.Marks;
import com.task_1.azure_basic_app.Models.Users;
import com.task_1.azure_basic_app.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    @PostMapping
    public ResponseEntity<?> addMark(@RequestBody Marks marks)
    {
        System.out.println(marks);
        return markService.addMarks(marks);

    }
    @GetMapping
    public List<Marks> getalldata()
    {
        return markService.getAllMarks();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMark(@PathVariable Long id,@RequestBody Marks marks)
    {

        return markService.UpdateMark(id,marks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMarkById(@PathVariable Long id)
    {

        return markService.getMarksById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMark(@PathVariable Long id)
    {
        return markService.deleteMarkById(id);
    }
}
