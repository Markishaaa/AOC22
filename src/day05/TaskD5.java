package day05;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import utils.Task;

public class TaskD5 implements Task {

	private Map<Integer, Deque<String>> crates;
	private final int crateWidth = 4;
	private int numberOfCrates = -1;

	public TaskD5() {
		this.crates = new HashMap<>();
	}

	private void readMap(String line) {
		String[] chars = line.split("");

		if (numberOfCrates == -1)
			numberOfCrates = (chars.length + 1) / crateWidth;

		int iChar = 0;
		for (int i = 1; i <= numberOfCrates; i++) {
			if (chars[iChar].equals("[")) {
				crates.computeIfAbsent(i, k -> new ArrayDeque<>()).addFirst(chars[iChar + 1]);
			}

			iChar += crateWidth;
		}
	}

	public void moveCrates(String line, int task) {

		if (line.contains("[")) {
			readMap(line);
			return;
		} else if (line.matches("[0-9 ]+") || line.isBlank() || line.isEmpty()) {
			return;
		}

		line = line.replaceAll("[^0-9]", "").trim();
		int from = Integer.parseInt(line.substring(line.length() - 2, line.length() - 1));
		int to = Integer.parseInt(line.substring(line.length() - 1));
		int numOfCrates = Integer.parseInt(line.substring(0, line.length() - 2));
		
		if (task == 1) {
			oneByOne(numOfCrates, from, to);
		} else {
			crateMover9001(numOfCrates, from, to);
		}
	}
	
	private void oneByOne(int numOfCrates, int from, int to) {
		for (int i = 0; i < numOfCrates; i++) {
			String s = crates.get(from).removeLast();
			crates.get(to).addLast(s);
		}
	}
	
	private void crateMover9001(int numOfCrates, int from, int to) {
		Deque<String> remove = new ArrayDeque<>();
		for (int i = 0; i < numOfCrates; i++) {
			String s = crates.get(from).removeLast();
			remove.addFirst(s);
		}
		
		crates.get(to).addAll(remove);
	}

	@Override
	public void task1(String line) {
		moveCrates(line, 1);
	}

	@Override
	public void task2(String line) {
		moveCrates(line, 2);
	}

	// Gets all the crates on top of the stacks
	@Override
	public Object getResult(int task) {
		String tops = "";
		for (int i = 1; i <= crates.size(); i++) {
			tops += crates.get(i).getLast();
		}
		
		return tops;
	}

}
