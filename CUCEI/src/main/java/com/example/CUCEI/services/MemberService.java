package com.example.CUCEI.services;

import com.example.CUCEI.Models.MemberModel;
import com.example.CUCEI.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    //obtener todos los gymMembers registrados
    public ArrayList<MemberModel> findAllMembers(){
        return (ArrayList<MemberModel>)memberRepository.findAll();
    }
    //guardar un gymMember
    public MemberModel saveMember(MemberModel member){
        return memberRepository.save(member);
    }

    //buscar por nombre
    public Optional<ArrayList<MemberModel>> findByName(String name){
        return memberRepository.findByName(name);
    }

    //buscar por código
    public Optional<MemberModel> findByCode(Integer code){
        return memberRepository.findByCode(code);
    }

    //eliminar por codigo
    public String deleteMemberByCode(Integer code){
        String response = "";

        Optional<MemberModel>foundStudent = findByCode(code);
        if(foundStudent.isPresent()){
            memberRepository.delete(foundStudent.get());
            response = "gymMember deleted seccussfully";
        }else {
            response = "gymMember not found";
        }
        return response;
    }

        //actualizar
    public MemberModel updateMemberByCode(Integer code, MemberModel memberModel){
        return findByCode(code).isPresent() ? memberRepository.save(memberModel) : new MemberModel();
}
}
