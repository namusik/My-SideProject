package com.woosik.sideproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberJoinDto {
    private String nickName;
    private String email;
    private String password;
}
