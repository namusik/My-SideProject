package com.woosik.sideproject.service;

import com.woosik.sideproject.domain.Member;
import com.woosik.sideproject.dto.MemberAddRequestDto;
import com.woosik.sideproject.repository.MemberRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
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
        MemberAddRequestDto memberSaveDto = new MemberAddRequestDto("test", "test@naver.com", "abc123");
        Member savedMember = memberService.add(memberSaveDto);
        Member findMember = memberRepository.findById(savedMember.getId())
                .orElseThrow(() -> new NullPointerException("값이 없다."));
        assertThat(savedMember).isEqualTo(findMember);
    }

    @Test
    void validateTest() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        MemberAddRequestDto memberAddRequestDto = new MemberAddRequestDto("test", "testnaver.com", "abc123");

        Set<ConstraintViolation<MemberAddRequestDto>> violations = validator.validate(memberAddRequestDto);
        for (ConstraintViolation<MemberAddRequestDto> violation : violations) {
            log.info("violation = {}", violation);
            log.info("violation.getMessage= {}", violation.getMessage());
        }
    }
}