package com.practice.jpa.chapter2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// @Entity :  이 클래스를 테이블과 매핑해준다고 JPA에게 알려줌
// @Table : 엔티티 클래스에 매핑할 테이블 정보를 알려준다
// @Id : 엔티티 클래스의 필드를 테이블의 기본키에 매핑한다.
// @Column : 필드를 컬럼에 매핑한다.
// 매핑 정보가 없는 필드는 알아서 필드명을 사용해서 컬럼명으로 매핑이 된다. (대소문자 구분을 하지 않는다고 가정)
@Data
@Entity
@Table(name="MEMBER")
public class Member {

    @Id
    @Column(name = "ID")
    private String id;  // 아이디

    @Column(name = "NAME")
    private String username;    //이름

    private Integer age;    // 나이
}
