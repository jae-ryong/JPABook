package com.practice.jpa.chapter2;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

// @Entity :  이 클래스를 테이블과 매핑해준다고 JPA에게 알려줌
// @Table : 엔티티 클래스에 매핑할 테이블 정보를 알려준다
// @Id : 엔티티 클래스의 필드를 테이블의 기본키에 매핑한다.
// @Column : 필드를 컬럼에 매핑한다.
// 매핑 정보가 없는 필드는 알아서 필드명을 사용해서 컬럼명으로 매핑이 된다. (대소문자 구분을 하지 않는다고 가정)
@Data
@Entity
@Table(name="MEMBER",  uniqueConstraints = {
        @UniqueConstraint(name = "NAME_AGE_UNIQUE", columnNames = {"NAME","AGE"})
})
public class Member {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;  // 아이디

    @Column(name = "NAME", nullable = false, length = 10)
    private String username;    //이름

    private Integer age;    // 나이

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;
}
