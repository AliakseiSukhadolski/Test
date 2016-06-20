package com.senla.test.core.impl;

import java.util.ArrayList;
import java.util.List;

import com.senla.test.core.api.Service;

public class CoreService implements Service {

	public List<Integer> expand(Integer number) {
		int factor = 2;
		List<Integer> list = new ArrayList<Integer>();
		while (number > 1 ) {
			while (number % factor == 0) {
				number /= factor;
				list.add(factor);
			}
			++factor;
		}
		if (number > 1) {
			list.add(factor);
		}
		return list;

	}

}
