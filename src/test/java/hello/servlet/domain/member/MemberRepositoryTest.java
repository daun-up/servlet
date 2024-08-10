package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    /*
    테스트가 끝날 때마다 실행되는 콜백 메서드
     */
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void getInstance() {
    }

    @Test
    void save() {
        //given (무언가 주어졌을 때)
        Member member = new Member("hello", 20);

        //when (이걸 실행했을 때)
        Member savedMember = memberRepository.save(member);

        //then (결과가 이게 나와야 함)
        Member findMember = memberRepository.findById(savedMember.getId());
//        assertEquals(findMember, savedMember);
        // 저장된 멤버와 찾아온 멤버가 같은지 확인한다.
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findById() {
    }

    /*
    모든 멤버를 찾아온다.
     */
    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2); // 개수가 맞는지 확인
        assertThat(result).contains(member1, member2); // 내용 같은지 확인
    }

    @Test
    void clearStore() {
    }
}