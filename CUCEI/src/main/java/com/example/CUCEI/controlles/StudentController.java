package com.example.CUCEI.controlles;

import com.example.CUCEI.Models.StudentModel;
import com.example.CUCEI.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/estudiantes")
public class StudentController {
    @Autowired
    StudentService studentService;

    //get
    @GetMapping("")
    public ArrayList<StudentModel> findAllStudents() {
        return studentService.findAllStudents();
    }

    //post
    @PostMapping("")
    public StudentModel saveStudent(@RequestBody StudentModel student) {
        return studentService.saveStudent(student);
    }

    //editar
    @PutMapping()
    public StudentModel updateStudent(@RequestBody StudentModel student) {
        return studentService.saveStudent(student);
    }

    //buscar por código
    @GetMapping(path = "/find-by-code") //localhost:8080/estudiantes/find-by-code/
    public Optional<StudentModel> findByCode(@RequestParam("code") String code){
        return studentService.findByCode(code);
    }

    //buscra por nombre
    @GetMapping(path = "/find-by-name") //localhost:8080/estudiantes/find-by-code/
    public Optional<ArrayList<StudentModel>> findByName(@RequestParam("name") String name){
        return studentService.findByName(name);
    }

    //borrar
    @CrossOrigin
    @DeleteMapping("/deleteStudentByCode={code}")
    public String deleteStudentByCode(@PathVariable String code){
        return studentService.deleteStudentByCode(code);
    }

    //actualizar
    @PutMapping("/updateStudentByCode={code}")
    public StudentModel updateStudent(@PathVariable String code, @RequestBody StudentModel studentModel){
        return studentService.updateStudentByCode(code, studentModel);
    }
}
