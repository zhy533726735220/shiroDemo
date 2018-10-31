package com.zhy.dao;

import com.zhy.vo.Member;

import java.util.Set;

public interface IMemberDAO {
	public Member findById(String mid) ;
	public Set<String> findAllRoleByMember(String mid) ;
	public Set<String> findAllActionByMember(String mid) ;
}
