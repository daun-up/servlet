package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려

 */

public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L; // 아이디가 하나씩 증가하는 것
    private static final MemberRepository instance = new MemberRepository(); // 싱글톤

    public static MemberRepository getInstance() { // 무조건 얘로 조회해야함
        return instance;
    }
    private MemberRepository() { // 싱글톤일 때는 아무나 생성하지 못하게 막아줘야 함

    };

    public Member save (Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById (Long id) {
        return store.get(id);
    }

    /*
    전체 회원 조회
    store 에 있는 모든 값을 꺼내서 새 리스트에 담아 반환
    직접 가져오지 않고 store 를 보호
     */
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
