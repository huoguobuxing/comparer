package com.myself.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.myself.business.Order;
import com.myself.business.OrderHeader;
import com.myself.business.OrderItem;
import com.myself.domain.TestResultHeader;
import com.myself.domain.TestResultItem;
import com.myself.domain.Value;
import com.myself.domain.comparator.BigDecimalComparator;

public class OrderTestService extends ATestService<OrderHeader, OrderItem> {

	@Override
	protected List<OrderItem> getItemBeansFromMemory(Order order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected OrderHeader getHeaderBeanFromMemory(Order order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected OrderItem findBean(List<OrderItem> items, OrderItem item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<TestResultItem> buildItemsCompareResult(List<OrderItem> merged, List<OrderItem> dbList,
			List<OrderItem> memoryList) throws Exception {
		// TODO Auto-generated method stub
		List<TestResultItem> result = new ArrayList<TestResultItem>();

		merged.sort(new OrderItemComparator());
		for (OrderItem bean : merged) {

			OrderItem db = this.findBean(dbList, bean);
			if (db != null) {
				dbList.remove(db);
			}
			OrderItem memory = this.findBean(memoryList, bean);
			if (memory != null) {
				memoryList.remove(memory);
			}

			if (db == null && memory == null) {
				continue;
			}

			TestResultItem temp = new TestResultItem();
			Map<String, Value<String>> columnValues = new LinkedHashMap<String, Value<String>>();

			columnValues.put("Discount",
					new Value<BigDecimal>(db != null ? defaultIfNull(db.getAmount(), BigDecimal.ZERO) : BigDecimal.ZERO,
							memory != null ? defaultIfNull(memory.getAmount(), BigDecimal.ZERO) : BigDecimal.ZERO,
							new BigDecimalComparator()).toStringValue());
			columnValues.get("Discount").setDescption("金额");

			temp.setColumns(columnValues);

			// 判断这一行是否一致
			if (

			!columnValues.get("OrderNo").isEqual()

			) {
				temp.setCorrect(false);
			}

			result.add(temp);
		}

		return result;
	}

	@Override
	protected com.myself.domain.TestResultHeader buildHeaderCompareResult(OrderHeader db, OrderHeader memory)
			throws Exception {

		TestResultHeader header = new TestResultHeader();

		Map<String, Value<String>> columnValues = new LinkedHashMap<String, Value<String>>();

		columnValues.put("OrderNo", new Value<String>(db != null ? (String) db.getOrderNo() : "",
				memory != null ? (String) memory.getOrderNo() : "", null));
		header.setColumns(columnValues);

		return header;
	}

	@Override
	protected List<OrderItem> getItemBeansFromDB(String orderNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected OrderHeader getHeaderBeanFromDB(String orderNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

class OrderItemComparator implements Comparator<OrderItem> {

	@Override
	public int compare(OrderItem o1, OrderItem o2) {
		return 0;
	}

}
