package com.woosik.sideproject.service;

import com.woosik.sideproject.domain.Member;
import com.woosik.sideproject.dto.MemberJoinDto;
import com.woosik.sideproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Member signUp(MemberJoinDto memberJoinDto) {
        Member member = new Member(memberJoinDto.getNickName(), memberJoinDto.getEmail(), memberJoinDto.getPassword());
        return memberRepository.save(member);
    }
}
