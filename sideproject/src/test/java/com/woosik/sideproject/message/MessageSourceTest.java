package com.woosik.sideproject.message;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import java.util.Locale;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class MessageSourceTest {
    @Autowired
    MessageSource messageSource;

    @Test
    @DisplayName("메세지소스 테스트")
    void message() {
        log.info("messageSource={}",messageSource);
        String message = messageSource.getMessage("label.myPage.title", null, Locale.getDefault());
        log.info("message={}",message);
        assertThat(message).isEqualTo("마이페이지 입니다.");
    }

    @Test
    @DisplayName("매개변수있는 메세지소스")
    void paramMessage() {
        String name = "nam";
        String name2 = "kim";
        String message = messageSource.getMessage("label.myPage.hello", new Object[]{name, name2}, Locale.getDefault());
        log.info("message={}",message);
        assertThat(message).isEqualTo("nam kim 반갑습니다.");
    }

    @Test
    @DisplayName("국제화 테스트")
    void errorMessage() {
        String errorMessage = messageSource.getMessage("error.noId", null, Locale.ENGLISH);
        log.info("errorMessage={}",errorMessage);
        assertThat(errorMessage).isEqualTo("There is no id.");
    }
}
