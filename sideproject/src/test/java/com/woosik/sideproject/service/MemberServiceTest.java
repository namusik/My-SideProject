package com.woosik.sideproject.service;

import com.woosik.sideproject.domain.Member;
import com.woosik.sideproject.dto.MemberJoinDto;
import com.woosik.sideproject.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void signUp() {
        MemberJoinDto memberJoinDto = new MemberJoinDto("test", "test@naver.com", "abc123");
        Member savedMember = memberService.signUp(memberJoinDto);
        Member findMember = memberRepository.findById(savedMember.getId()).orElseThrow(() -> new NullPointerException("값이 없다."));
        assertThat(savedMember).isEqualTo(findMember);
    }
}