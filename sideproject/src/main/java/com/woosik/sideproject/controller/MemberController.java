package com.woosik.sideproject.controller;

import com.woosik.sideproject.domain.Member;
import com.woosik.sideproject.dto.MemberJoinDto;
import com.woosik.sideproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signUp")
    public String signUpPage(Model model) {
        model.addAttribute("member", new Member());
        return "member/signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute MemberJoinDto memberJoinDto, RedirectAttributes redirectAttributes) {
        Member member = memberService.signUp(memberJoinDto);
        redirectAttributes.addAttribute("memberId", member.getId());
        return "redirect:/members/{memberId}";
    }

    @GetMapping("/{memberId}")
    public String myPage(@PathVariable long memberId, Model model) {
        Member findMember = memberService.findById(memberId);
        model.addAttribute("member", findMember);
        return "member/myPage";
    }
}
