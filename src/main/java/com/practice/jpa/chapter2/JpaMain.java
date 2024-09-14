package com.practice.jpa.chapter2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class JpaMain {

    public static void main(String[] args) {
        SpringApplication.run(JpaMain.class, args);
    }
}

@Component
class JpaRunner implements CommandLineRunner {

    private final LoginService loginService;

    public JpaRunner(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void run(String... args) throws Exception {
        loginService.login();  // 다른 빈에서 호출
    }
}

@Component
class LoginService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void login() {
        // 비즈니스 로직 구현
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("재룡");
        member.setAge(2);

        // 등록
        em.persist(member);

        // 수정
        member.setAge(26);

        // 한 건 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember=" + findMember.getUsername() + " age=" + findMember.getAge());

        String id2 = "id2";  // id 값 수정
        Member member2 = new Member();
        member2.setId(id2);  // member2 객체에 id2를 설정
        member2.setUsername("수한");
        member2.setAge(21);
        em.persist(member2);

        // 목록 조회
        List<Member> members =
                em.createQuery("select m from Member m", Member.class)
                        .getResultList();
        System.out.println("member.size()=" + members.size());

        // 삭제
        em.remove(member);
    }
}