package com.myself.service;

import java.util.ArrayList;
import java.util.List;

import com.myself.business.Order;
import com.myself.domain.TestResult;
import com.myself.domain.TestResultHeader;
import com.myself.domain.TestResultItem;

public abstract class ATestService<Header, Item> {

	public TestResult test(Order order) {
		try {
			TestResultHeader header = this.getHeader(order);
			List<TestResultItem> items = this.getItems(order);
			TestResult result = new TestResult(header, items);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	private TestResultHeader getHeader(Order order) throws Exception {

		Header dbBean = this.getHeaderBeanFromDB(order.getHeader().getOrderNo());
		Header memoryBean = this.getHeaderBeanFromMemory(order);

		return this.buildHeaderCompareResult(dbBean, memoryBean);
	}

	protected abstract List<Item> getItemBeansFromDB(String orderNo) throws Exception;

	protected abstract List<Item> getItemBeansFromMemory(Order order) throws Exception;

	protected abstract Header getHeaderBeanFromDB(String orderNo) throws Exception;

	protected abstract Header getHeaderBeanFromMemory(Order order) throws Exception;

	protected abstract Item findBean(List<Item> items, Item item);

	private List<TestResultItem> getItems(Order order) throws Exception {
		List<Item> dbList = this.getItemBeansFromDB(order.getHeader().getOrderNo());
		List<Item> memoryList = this.getItemBeansFromMemory(order);

		List<Item> merged = new ArrayList<Item>();
		merged.addAll(dbList);
		merged.addAll(memoryList);

		return buildItemsCompareResult(merged, dbList, memoryList);
	}

	protected abstract List<TestResultItem> buildItemsCompareResult(List<Item> merged, List<Item> dbList,
			List<Item> memoryList) throws Exception;

	protected abstract TestResultHeader buildHeaderCompareResult(Header db, Header memory) throws Exception;

	protected <T> T defaultIfNull(final T methodReturnValue, final T defaultValue) {
		return methodReturnValue == null ? defaultValue : methodReturnValue;
	}

}
