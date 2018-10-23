package com.myself.domain;

import java.util.List;

public class TestResult {

	private TestResultHeader header = null;
	private List<TestResultItem> items = null;
	/** �ô���Ա��Ƿ���ȷ */
	private boolean correct = true;

	public TestResultHeader getHeader() {
		return header;
	}

	public void setHeader(TestResultHeader header) {
		this.header = header;
	}

	public List<TestResultItem> getItems() {
		return items;
	}

	public void setItems(List<TestResultItem> items) {
		this.items = items;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public TestResult(TestResultHeader header, List<TestResultItem> items) {
		this.header = header;
		this.items = items;
		if (!header.isCorrect()) {
			this.correct = false;
		}
		// header��items��correct,������һ����false,�������false
		for (TestResultItem item : items) {
			if (!item.isCorrect()) {
				this.correct = false;
			}
		}

	}
}
