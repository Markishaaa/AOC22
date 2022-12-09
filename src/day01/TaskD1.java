package day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Task;

public class TaskD1 implements Task {

	private int most;
	private int current;
	private List<Integer> calories;

	public TaskD1() {
		this.most = Integer.MIN_VALUE;
		this.current = 0;
		this.calories = new ArrayList<>();
	}

	@Override
	public void task1(String data) {
		if (data.isEmpty() || data.isBlank()) {
			if (most < current) {
				most = current;
			}
			calories.add(current);
			current = 0;
		} else {
			current += Integer.parseInt(data);
		}
	}

	@Override
	public void task2(String data) {
		task1(data);
	}

	@Override
	public Object getResult(int task) {
		if (task == 1)
			return most;

		return calories.stream().sorted(Collections.reverseOrder()).limit(3).reduce(0, Integer::sum);
	}

}
