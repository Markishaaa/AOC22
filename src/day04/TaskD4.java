package day04;

import java.util.Arrays;

import utils.Task;

public class TaskD4 implements Task {

	private int count;
	private int[] n1, n2;

	public TaskD4() {
		this.count = 0;
	}

	private void setFields(String s) {
		String[] sections = s.split(",");

		n1 = Arrays.stream(sections[0].split("-")).mapToInt(Integer::parseInt).toArray();
		n2 = Arrays.stream(sections[1].split("-")).mapToInt(Integer::parseInt).toArray();
	}

	// Finds how many pairs contain other pair
	@Override
	public void task1(String line) {
		setFields(line);

		if ((n1[0] <= n2[0] && n1[1] >= n2[1]) || (n2[0] <= n1[0] && n2[1] >= n1[1])) {
			count++;
		}
	}

	// Finds how many pairs overlap
	@Override
	public void task2(String line) {
		setFields(line);

		if ((n1[0] <= n2[0] && n1[1] >= n2[1]) || (n2[0] <= n1[0] && n2[1] >= n1[1])
				|| (n1[0] <= n2[0] && n2[0] <= n1[1] && n1[1] <= n2[1])
				|| (n2[0] <= n1[0] && n1[0] <= n2[1] && n2[1] <= n1[1]))
			count++;
	}

	@Override
	public Object getResult(int task) {
		return count;
	}

}
