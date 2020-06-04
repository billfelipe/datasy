package com.billfelipe.datasy.model;

public abstract class Feature {

	private final double[] values;

	public Feature(double[] values) {
		this.values = values;
	}

	public double[] getValues() {
		return values;
	}

}
