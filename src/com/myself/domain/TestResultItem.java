package com.myself.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestResultItem {
	
	private Map<String, Value<String>> columns = new LinkedHashMap<String, Value<String>>();
	private boolean correct = true;

	public TestResultItem() {
		super();
	}

	public Map<String, Value<String>> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, Value<String>> columns) {
		this.columns = columns;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
}
