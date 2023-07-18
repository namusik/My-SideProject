package com.woosik.sideproject.service;

import com.woosik.sideproject.domain.Member;
import com.woosik.sideproject.dto.MemberJoinDto;
import com.woosik.sideproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member signUp(MemberJoinDto memberJoinDto) {
        Member member = new Member(memberJoinDto.getNickname(), memberJoinDto.getEmail(), memberJoinDto.getPassword());
        return memberRepository.save(member);
    }

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("없는 사용자"));
    }
}
