package com.woosik.sideproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private String nickName;
  private String email;
  private String password;

  public Member(String nickName, String email, String password) {
    this.nickName = nickName;
    this.email = email;
    this.password = password;
  }
}