package com.framework.study.member.service;

import com.framework.study.member.domain.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
