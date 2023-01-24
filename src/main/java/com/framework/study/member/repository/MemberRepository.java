package com.framework.study.member.repository;

import com.framework.study.member.domain.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
