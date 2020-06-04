package com.billfelipe.datasy.util;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class FileUtilTest {

	@Test
	public void testSplit() {
		String line = "1,2,-3,0.4";
		String[] columns = FileUtil.split(line, ",");
		Assert.assertNotNull(columns);
		Assert.assertEquals(4, columns.length);
		Assert.assertEquals("1", columns[0]);
		Assert.assertEquals("2", columns[1]);
		Assert.assertEquals("-3", columns[2]);
		Assert.assertEquals("0.4", columns[3]);
	}
	
	@Test
	public void testToDouble() {
		String line = "1,2,-3,0.4";
		String[] columns = FileUtil.split(line, ",");
		double[] values = FileUtil.toDouble(columns);
		Assert.assertNotNull(values);
		Assert.assertEquals(4, values.length);
		Assert.assertEquals(1, values[0] , 0.001);
		Assert.assertEquals(2, values[1] , 0.001);
		Assert.assertEquals(-3, values[2] , 0.001);
		Assert.assertEquals(.4, values[3] , 0.001);
		
	}
	
}
