package com.greedy.section01.connection.javaconfig;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("menuDAO")
public class MenuDAOImpl implements MenuDAO {

	@Override
	public List<MenuDTO> selectMenuList(SqlSessionTemplate sqlSession) {

		//SqlSessionTemplate = 연결 정보값

		// "mapper의namespace.id"
		return sqlSession.selectList("MenuMapper.selectMenuList");
	}

}
