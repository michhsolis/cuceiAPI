package com.example.CUCEI.controlles;

import com.example.CUCEI.Models.MemberModel;
import com.example.CUCEI.services.MemberService;
import com.example.CUCEI.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/GymMembers")
public class MemberController {
    @Autowired
    MemberService memberService;

    //get
    @GetMapping("")
    public ArrayList<MemberModel> findAllMembers() {
        return memberService.findAllMembers();
    }

    //post
    @PostMapping("")
    public MemberModel saveMember(@RequestBody MemberModel member) {
        return memberService.saveMember(member);
    }

    //editar
    @PutMapping()
    public MemberModel updateMember(@RequestBody MemberModel member) {
        return memberService.saveMember(member);
    }

    //buscar por código
    @GetMapping(path = "/find-by-code") //localhost:8080/GymMembers/find-by-code/
    public Optional<MemberModel> findByCode(@RequestParam("code") Integer code){
        return memberService.findByCode(code);
    }

    //buscar por nombre
    @GetMapping(path = "/find-by-name") //localhost:8080/estudiantes/find-by-name/
    public Optional<ArrayList<MemberModel>> findByName(@RequestParam("name") String name){
        return memberService.findByName(name);
    }

    //borrar
    @CrossOrigin
    @DeleteMapping("/deleteMemberByCode={code}")
    public String deleteMemberByCode(@PathVariable Integer code){
        return memberService.deleteMemberByCode(code);
    }

    //actualizar
    @PutMapping("/updateMemberByCode={code}")
    public MemberModel updateMember(@PathVariable Integer code, @RequestBody MemberModel memberModel){
        return memberService.updateMemberByCode(code, memberModel);
    }
}
