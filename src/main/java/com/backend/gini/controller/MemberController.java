package com.backend.gini.controller;

import com.backend.gini.domain.entity.MemberEntity;
import com.backend.gini.domain.global.Response;
import com.backend.gini.domain.repository.MemberRepository;
import com.backend.gini.service.MemberService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;


@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    private final Logger log = LoggerFactory.getLogger(MemberController.class);

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public Response loginUser(@RequestBody MemberEntity memberEntity){
        Response response = new Response();
        try {
            response.setResult(memberService.loginUser(memberEntity));
            response.setMessage("success");
            response.setStatus(HttpStatus.OK.value());
        }catch (Exception e){
            response.setMessage("failed");
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }

        return response;
    }

}
