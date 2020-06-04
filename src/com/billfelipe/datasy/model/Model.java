package com.billfelipe.datasy.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public final class Model {

	private List<Data> data = new ArrayList<>();

	private final int inputSize;
	private final int outputSize;

	public Model(final int inputSize, final int outputSize) {
		this.inputSize = inputSize;
		this.outputSize = outputSize;
	}

	public Model(final Collection<Data> data) throws Exception {
		this.inputSize = data.iterator().next().getInputSize();
		this.outputSize = data.iterator().next().getOutputSize();
		addData(data);
	}

	public Model(final double[][] inputValues, final double[][] outputValues) throws Exception {
		this.inputSize = inputValues[0].length;
		this.outputSize = outputValues[0].length;
		for (int i = 0; i < inputValues.length; i++) {
			addData(new Data(inputValues[i], outputValues[i]));
		}
	}

	public void addData(final Collection<Data> data) throws Exception {
		for (Data d : data) {
			addData(d);
		}
	}

	public void addData(final Data data) throws Exception {
		validateDataDimensions(data);
		this.data.add(data);
	}

	public void removeData(final Data data) {
		this.data.remove(data);
	}

	public void removeData(final Collection<Data> data) {
		this.data.removeAll(data);
	}

	public Collection<Data> getData() {
		return new ArrayList<Data>(this.data);
	}

	public Collection<Data> getSampleData(float rate) {
		int sampleSize = getSampleSize(rate);
		List<Data> sample = new ArrayList<>();
		while (sampleSize > 0) {
			Data randomData = getRandomData();
			if (sample.contains(randomData)) {
				continue;
			}
			sample.add(randomData);
			sampleSize--;
		}
		return sample;
	}

	int getSampleSize(final float rate) {
		return (int) (this.data.size() * rate);
	}

	Data getRandomData() {
		Random random = new Random();
		int index = random.nextInt(this.data.size());
		return data.get(index);
	}

	void validateDataDimensions(final Data data) throws Exception {
		if (this.inputSize > data.getInputSize()) {
			throw new Exception("Data input dimensions are smaller than dataset input size");
		}
		if (this.inputSize < data.getInputSize()) {
			throw new Exception("Data input dimensions are bigger than dataset input size");
		}
		if (this.outputSize > data.getOutputSize()) {
			throw new Exception("Data output dimensions are smaller than dataset output size");
		}
		if (this.outputSize < data.getOutputSize()) {
			throw new Exception("Data output dimensions are bigger than dataset output size");
		}
	}

	public int getInputSize() {
		return this.inputSize;
	}

	public int getOutputSize() {
		return this.outputSize;
	}

}
