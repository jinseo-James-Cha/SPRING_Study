package com.greedy.section01.programmtic.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.section01.programmtic.model.dao.OrderMapper;
import com.greedy.section01.programmtic.model.dto.OrderDTO;
import com.greedy.section01.programmtic.model.dto.OrderMenuDTO;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	private SqlSessionTemplate sqlSession;

	@Autowired
	public OrderServiceImpl(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int registOrder(OrderDTO order) {

		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		int orderResult = orderMapper.insertOrder(order);
		
		List<OrderMenuDTO> orderMenuList = order.getMenuList();
		int orderMenuResult = 0;
		for(OrderMenuDTO orderMenu : orderMenuList) {
			orderMenuResult += orderMapper.insertOrderMenu(orderMenu);
		}
		
		
		return 0;
	}

}
