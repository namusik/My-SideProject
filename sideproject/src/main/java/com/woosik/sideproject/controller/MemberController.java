package com.woosik.sideproject.controller;

import com.woosik.sideproject.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/members")
public class MemberController {

    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("member", new Member());
        return "member/signUp";
    }

    @GetMapping("/myPage")
    public String myPage() {
        return "member/myPage";
    }
}
