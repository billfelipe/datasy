package com.billfelipe.datasy.model;

public final class Data {

	private final Input input;
	private final Output output;

	public Data(Input input, Output output) {
		super();
		this.input = input;
		this.output = output;
	}

	public Data(final double[] inputValues, final double[] outputValues) {
		this.input = new Input(inputValues);
		this.output = new Output(outputValues);
	}

	public Input getInput() {
		return input;
	}

	public Output getOutput() {
		return output;
	}

	public int getInputSize() {
		return input.getValues().length;
	}

	public int getOutputSize() {
		return output.getValues().length;
	}

}
