package com.woosik.sideproject.controller;

import com.woosik.sideproject.domain.Member;
import com.woosik.sideproject.dto.MemberSaveDto;
import com.woosik.sideproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signUp")
    public String addForm(Model model) {
        model.addAttribute("member", new Member());
        return "/member/addForm";
    }

    @PostMapping("/signUp")
    public String add(@Validated @ModelAttribute("member") MemberSaveDto memberSaveDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "member/addForm";
        }

        Member member = memberService.signUp(memberSaveDto);
        redirectAttributes.addAttribute("memberId", member.getId());
        return "redirect:/members/{memberId}";
    }

    @GetMapping("/edit/{memberId}")
    public String edit(@PathVariable Long memberId, Model model) {
        Member member = memberService.findById(memberId);
        model.addAttribute("member", member);
        return "member/editForm";
    }



    @GetMapping("/{memberId}")
    public String myPage(@PathVariable long memberId, Model model) {
        Member findMember = memberService.findById(memberId);
        model.addAttribute("member", findMember);
        return "member/myPage";
    }
}
