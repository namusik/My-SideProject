package com.woosik.sideproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberJoinDto {
    private String nickname;
    private String email;
    private String password;
}
