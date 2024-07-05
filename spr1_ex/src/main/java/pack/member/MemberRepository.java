package pack.member;

//회원 저장소 인터페이스를 생성
public interface MemberRepository {
	void save(Member member);
	
	Member findById(Long memberId);
}
