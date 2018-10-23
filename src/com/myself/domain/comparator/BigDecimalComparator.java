package com.myself.domain.comparator;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class BigDecimalComparator extends BaseComparator<BigDecimal> {

	public BigDecimalComparator() {
		super();
	}

	private int scale = 6;

	public BigDecimalComparator(int scale) {
		if (scale >= 0) {
			this.scale = scale;
		}
	}

	@Override
	public int compare(BigDecimal o1, BigDecimal o2) {
		// TODO Auto-generated method stub
		o1.setScale(scale);
		o2.setScale(scale);

		if (o1.doubleValue() == o2.doubleValue())
			return 0;
		return o1.doubleValue() > o2.doubleValue() ? 1 : -1;
	}

	@Override
	public BigDecimal adjustFormat(BigDecimal t) {
		// TODO Auto-generated method stub
		if (t != null) {
			return t.setScale(scale,RoundingMode.HALF_UP);
		}
		return t;
	}
}
