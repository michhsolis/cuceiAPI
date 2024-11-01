package com.example.CUCEI.repositories;

import com.example.CUCEI.Models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;


@Repository
public interface StudentRepository extends CrudRepository <StudentModel,Long> {

    //buscar por codigo
    public abstract Optional<StudentModel> findByCode(String code);

    // buscar por nombre
    public abstract  Optional<ArrayList<StudentModel>> findByName(String name);
    //eliminar por codigo
    public void deleteStudentByCode(String code);
}
