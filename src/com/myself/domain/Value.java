package com.myself.domain;

import com.myself.domain.comparator.BaseComparator;

public class Value<T> {
	private T dbValue;
	private T meValue;
	private BaseComparator<T> comparator;
	private String descption = "";

	public Value(T dbValue, T meValue, BaseComparator<T> comparator2) {
		super();
		this.dbValue = dbValue;
		this.meValue = meValue;
		this.comparator = comparator2;
	}

	public boolean isEqual() {
		if (this.comparator != null) {
			return comparator.compare(dbValue, meValue) == 0;
		} else {
			return this.dbValue.equals(this.meValue);
		}
	}

	public T getDbValue() {
		return dbValue;
	}

	public void setDbValue(T dbValue) {
		this.dbValue = dbValue;
	}

	public T getMeValue() {
		return meValue;
	}

	public void setMeValue(T meValue) {
		this.meValue = meValue;
	}

	public Value<String> toStringValue() {
		T tempDbValue = this.dbValue;
		T tempMeValue = this.meValue;

		if (this.comparator != null) {
			tempDbValue = this.comparator.adjustFormat(tempDbValue);
			tempMeValue = this.comparator.adjustFormat(tempMeValue);
		}

		String dbValue = tempDbValue == null ? "" : tempDbValue.toString();
		String meValue = tempMeValue == null ? "" : tempMeValue.toString();
		Value<String> value = new Value<String>(dbValue, meValue, null);
		value.setDescption(this.getDescption());
		return value;
	}

	public String getDescption() {
		return descption;
	}

	public void setDescption(String descption) {
		this.descption = descption;
	}
}
