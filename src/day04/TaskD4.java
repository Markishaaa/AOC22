package day04;

import java.util.Arrays;

public class TaskD4 {

	private int count;
	private int[] n1, n2;

	public TaskD4() {
		this.count = 0;
	}

	public void findContains(String line) {
		setFields(line);

		if ((n1[0] <= n2[0] && n1[1] >= n2[1]) || (n2[0] <= n1[0] && n2[1] >= n1[1])) {
			count++;
		}
	}

	public void findOverlaps(String line) {
		setFields(line);

		if ((n1[0] <= n2[0] && n1[1] >= n2[1]) || (n2[0] <= n1[0] && n2[1] >= n1[1])
				|| (n1[0] <= n2[0] && n2[0] <= n1[1] && n1[1] <= n2[1])
				|| (n2[0] <= n1[0] && n1[0] <= n2[1] && n2[1] <= n1[1]))
			count++;
	}

	private void setFields(String s) {
		String[] sections = s.split(",");
		
		n1 = Arrays.stream(sections[0].split("-")).mapToInt(Integer::parseInt).toArray();
		n2 = Arrays.stream(sections[1].split("-")).mapToInt(Integer::parseInt).toArray();
	}

	public int getCount() {
		return count;
	}

}
