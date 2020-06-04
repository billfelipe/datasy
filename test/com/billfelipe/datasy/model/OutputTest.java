package com.billfelipe.datasy.model;

import org.junit.Assert;
import org.junit.Test;

public class OutputTest {

	static double[] values = new double[] { 100.1, 1000.2 };
	static Feature output = new Output(values);

	@Test
	public void test() {
		Assert.assertNotNull(output.getValues());
		Assert.assertEquals(values.length, output.getValues().length);
		for (int i = 0; i < values.length; i++) {
			Assert.assertEquals(values[i], output.getValues()[i], 0.001);
		}
	}

}
