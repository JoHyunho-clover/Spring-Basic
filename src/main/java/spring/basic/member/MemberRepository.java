package spring.basic.member;

public interface MemberRepository {
    void save(Member member);//회원 가입

    Member findById(Long memberId);//id로 회원 조회
}
