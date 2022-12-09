package day03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.Task;

public class TaskD3 implements Task {

	private List<String> group;
	private int sum;

	public TaskD3() {
		this.group = new ArrayList<>();
		this.sum = 0;
	}

	private static Set<Character> convertStringToSetOfChars(String string) {
		Set<Character> set = new HashSet<>(string.length() + 10);
		for (char c : string.toCharArray()) {
			set.add(c);
		}

		return set;
	}

	// Finds common characters
	@Override
	public void task1(String line) {
		int mid = line.length() / 2;
		String[] compartments = { line.substring(0, mid), line.substring(mid) };

		for (int i = 0; i < mid; i++) {
			if (compartments[1].contains(Character.toString(compartments[0].charAt(i)))) {
				char c = compartments[0].charAt(i);
				int num = 0;

				if (Character.isUpperCase(c)) {
					num = (int) c - 38;
				} else if (Character.isLowerCase(c)) {
					num = (int) c - 96;
				} else {
					num = 0;
				}

				sum += num;
				break;
			}
		}
	}

	// Finds common badges
	@Override
	public void task2(String line) {
		group.add(line);

		if (group.size() % 3 == 0) {

			Set<Character> commonChars = convertStringToSetOfChars(group.get(0));
			group.stream().skip(1).forEach(s -> commonChars.retainAll(convertStringToSetOfChars(s)));

			for (char c : commonChars) {
				sum += Character.isUpperCase(c) ? (int) c - 38 : (int) c - 96;
			}

			group.clear();
		}
	}

	@Override
	public Object getResult(int task) {
		return sum;
	}

}
