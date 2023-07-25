package com.woosik.sideproject.service;

import com.woosik.sideproject.domain.Member;
import com.woosik.sideproject.dto.MemberSaveDto;
import com.woosik.sideproject.repository.MemberRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;
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
        MemberSaveDto memberSaveDto = new MemberSaveDto("test", "test@naver.com", "abc123");
        Member savedMember = memberService.signUp(memberSaveDto);
        Member findMember = memberRepository.findById(savedMember.getId())
                .orElseThrow(() -> new NullPointerException("값이 없다."));
        assertThat(savedMember).isEqualTo(findMember);
    }

    @Test
    void signUpError() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        MemberSaveDto memberSaveDto = new MemberSaveDto("test", "testnaver.com", "abc123");

        Set<ConstraintViolation<MemberSaveDto>> violations = validator.validate(memberSaveDto);
        for (ConstraintViolation<MemberSaveDto> violation : violations) {
            log.info("violation = {}", violation);
            log.info("violation.getMessage= {}", violation.getMessage());
        }
    }
}