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
  private String nickname;
  private String email;
  private String password;

  public Member(String nickname, String email, String password) {
    this.nickname = nickname;
    this.email = email;
    this.password = password;
  }

  public void update(String nickname, String email, String password) {
    this.nickname = nickname;
    this.email = email;
    this.password = password;
  }
}