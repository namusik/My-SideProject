package com.woosik.sideproject.service;

import com.woosik.sideproject.domain.Member;
import com.woosik.sideproject.dto.MemberAddRequestDto;
import com.woosik.sideproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member add(MemberAddRequestDto memberAddRequestDto) {
        Member member = new Member(memberAddRequestDto.getNickname(), memberAddRequestDto.getEmail(), memberAddRequestDto.getPassword());
        return memberRepository.save(member);
    }

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("없는 사용자"));
    }

    @Transactional
    public Member edit(MemberAddRequestDto memberUpdateDto, Long memberId) {
        Member findById = findById(memberId);
        findById.edit(memberUpdateDto.getNickname(), memberUpdateDto.getEmail(), memberUpdateDto.getPassword());

        return findById;
    }
}
