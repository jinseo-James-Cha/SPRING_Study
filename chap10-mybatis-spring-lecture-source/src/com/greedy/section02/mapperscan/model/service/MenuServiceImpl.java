package com.greedy.section02.mapperscan.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.greedy.section01.connection.javaconfig.MenuDAO;
import com.greedy.section02.mapperscan.model.dto.MenuDTO;


@Service("menuService")
public class MenuServiceImpl implements MenuService {

	private final SqlSessionTemplate sqlSession;
	
	public MenuServiceImpl(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<MenuDTO> selectMenuList() {
		
		/* 매퍼를 불러와서 메소드를 호출한다. */
		return sqlSession.getMapper(MenuDAO.class).selectMenuList();
	}

}
