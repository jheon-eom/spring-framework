package com.framework.study.member.service;

import com.framework.study.member.repository.MemberRepository;
import com.framework.study.member.repository.MemoryMemberRepository;
import com.framework.study.member.domain.Member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
