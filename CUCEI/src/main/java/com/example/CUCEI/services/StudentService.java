package com.example.CUCEI.services;

import com.example.CUCEI.Models.StudentModel;
import com.example.CUCEI.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //obtener todos los estudiantes registrados
    public ArrayList<StudentModel> findAllStudents(){
        return (ArrayList<StudentModel>)studentRepository.findAll();
    }
    //guardar un estudiante
    public StudentModel saveStudent(StudentModel student){
        return studentRepository.save(student);
    }

    //buscar por nombre
    public Optional<ArrayList<StudentModel>> findByName(String name){
        return studentRepository.findByName(name);
    }

    //buscra por código
    public Optional<StudentModel> findByCode(String code){
        return studentRepository.findByCode(code);
    }

    //eliminar por codigo
    public String deleteStudentByCode(String code){
        String response = "";

        Optional<StudentModel>foundStudent = findByCode(code);
        if(foundStudent.isPresent()){
            studentRepository.delete(foundStudent.get());
            response = "Student deleted seccussfully";
        }else {
            response = "Student not found";
        }
        return response;
    }

        //actualizar
    public StudentModel updateStudentByCode(String code, StudentModel studentModel){
        return findByCode(code).isPresent() ? studentRepository.save(studentModel) : new StudentModel();
}
}
