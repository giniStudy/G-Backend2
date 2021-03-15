package com.backend.gini.service;



import com.backend.gini.domain.entity.MemberEntity;
import com.backend.gini.domain.global.Response;
import com.backend.gini.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public MemberEntity loginUser(MemberEntity memberEntity) throws Exception {
        MemberEntity memberEntityInDB = memberRepository.findByName(memberEntity.getName());
        if(memberEntityInDB == null)throw new Exception("존재하지 않는회원.");
        if(!memberEntityInDB.getPassword().equals(memberEntity.getPassword())) throw new Exception("비밀번호가 일치하지 않습니다.");
        return memberEntityInDB;
    }


}
