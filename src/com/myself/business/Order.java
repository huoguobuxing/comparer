package com.myself.business;

public class Order {

	private OrderHeader header;
	private OrderItem item;

	public OrderHeader getHeader() {
		return header;
	}

	public void setHeader(OrderHeader header) {
		this.header = header;
	}

	public OrderItem getItem() {
		return item;
	}

	public void setItem(OrderItem item) {
		this.item = item;
	}

}
