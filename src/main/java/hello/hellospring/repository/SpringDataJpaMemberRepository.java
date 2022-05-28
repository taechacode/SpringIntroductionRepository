package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL 번역 : select m from Member m where m.name = ? (인터페이스 이름만으로도 단순한 쿼리는 개발 완료)
    @Override
    Optional<Member> findByName(String name);

}
