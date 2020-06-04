package com.billfelipe.datasy.model;

import org.junit.Assert;
import org.junit.Test;

public class InputTest {

	static double[] values = new double[] { 0.9, 1.1, 2.2 };
	static Feature input = new Input(values);

	@Test
	public void test() {
		Assert.assertNotNull(input.getValues());
		Assert.assertEquals(values.length, input.getValues().length);
		for (int i = 0; i < values.length; i++) {
			Assert.assertEquals(values[i], input.getValues()[i], 0.001);
		}
	}

}
