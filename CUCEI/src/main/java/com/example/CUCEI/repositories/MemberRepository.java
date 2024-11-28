package com.example.CUCEI.repositories;

import com.example.CUCEI.Models.MemberModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;


@Repository
public interface MemberRepository extends CrudRepository <MemberModel,Long> {

    //buscar por codigo
    public abstract Optional<MemberModel> findByCode(Integer code);

    // buscar por nombre
    public abstract  Optional<ArrayList<MemberModel>> findByName(String name);
    //eliminar por codigo
    public void deleteMemberByCode(Integer code);
}
