package com.project.Diary.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<Album> albumList;


    @Builder
    public Member(Long memberId, String memberName, String password, String email, LocalDateTime createdAt, List<Album> albumList) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
        this.albumList = albumList;

    }
}
