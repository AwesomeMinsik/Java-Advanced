package io.member;

import java.io.IOException;
import java.util.List;

public interface memberRepository {

    void add(Member member) throws IOException;

    List<Member> findAll();

}
