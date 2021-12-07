package spring.springintroduce.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spring.springintroduce.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member_1 = new Member();
        member_1.setName("Spring_1");
        repository.save(member_1);

        Member member_2 = new Member();
        member_2.setName("Spring_2");
        repository.save(member_2);


        Member result = repository.findByName("Spring_2").get();
        assertThat(result).isEqualTo(member_2);
    }

    @Test
    public void findAll() {
        Member member_1 = new Member();
        member_1.setName("Spring_1");
        repository.save(member_1);

        Member member_2 = new Member();
        member_2.setName("Spring_2");
        repository.save(member_2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}
