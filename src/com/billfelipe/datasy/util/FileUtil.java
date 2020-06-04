package com.billfelipe.datasy.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import com.billfelipe.datasy.model.Data;
import com.billfelipe.datasy.model.Model;
import com.billfelipe.datasy.model.Input;
import com.billfelipe.datasy.model.Output;

public abstract class FileUtil {

	public static Model importDataset(final String path, final boolean doesFirstLineContainHeaders,
			final String columnSeparator, final int inputSize, final int outputSize) throws Exception {
		Model dataset = new Model(inputSize, outputSize);
		FileReader fileReader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		if (doesFirstLineContainHeaders) {
			bufferedReader.readLine();// pula a primeira linha com os cabecalhos
		}
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			String[] columns = split(line, columnSeparator);
			double[] values = toDouble(columns);
			Input input = getInput(values, inputSize);
			Output output = getOutput(values, inputSize);
			dataset.addData(new Data(input, output));
		}
		bufferedReader.close();
		return dataset;
	}

	static Input getInput(final double[] values, final int inputSize) {
		return new Input(Arrays.copyOfRange(values, 0, inputSize));
	}

	static Output getOutput(final double[] values, final int inputSize) {
		return new Output(Arrays.copyOfRange(values, inputSize, values.length));
	}

	static String[] split(final String line, final String columnSeparator) {
		return line.split(columnSeparator);
	}

	static double[] toDouble(final String[] columns) {
		double[] values = new double[columns.length];
		for (int i = 0; i < columns.length; i++) {
			values[i] = Double.valueOf(columns[i]);
		}
		return values;
	}

}
