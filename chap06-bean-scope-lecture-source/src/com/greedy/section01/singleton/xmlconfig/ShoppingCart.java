package com.greedy.section01.singleton.xmlconfig;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private final List<Product> items;
	
	public ShoppingCart() {
		items = new ArrayList<>();
	}
	
	public void addItem(Product item) {
		items.add(item);
	}
	
	public List<Product> getItem(){
		return items;
	}
}
