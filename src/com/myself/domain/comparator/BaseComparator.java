package com.myself.domain.comparator;
import java.util.Comparator;

public abstract class BaseComparator<T> implements Comparator<T>{
	public abstract T adjustFormat(T t);
}
