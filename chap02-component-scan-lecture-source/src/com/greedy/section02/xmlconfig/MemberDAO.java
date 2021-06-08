package com.greedy.section02.xmlconfig;

public interface MemberDAO {

	/* 회원번호로 회원정보를 조회하는 메소드  */
	MemberDTO selectMember(int sequence);
	
	/* 회원정보를 저장하고 결과를 리턴하는 메소드 */
	boolean insertMEmber(MemberDTO newMember);
	
}
