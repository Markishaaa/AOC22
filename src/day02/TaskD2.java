package day02;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import utils.Task;

public class TaskD2 implements Task {

	private int score = 0;

	private final List<String> moves = Arrays.asList(
			"A Z", "B X", "C Y", 
			"A X", "B Y", "C Z", 
			"A Y", "B Z", "C X"
			);
	private final List<String> strats = Arrays.asList(
			"A X", "B X", "C X", 
			"A Y", "B Y", "C Y", 
			"A Z", "B Z", "C Z"
			);
	private final Map<String, Integer> dictionary = new LinkedHashMap<>();

	public TaskD2() {
		int j = 0;
		for (int i = 0; i < moves.size(); i++) {
			if (i % 3 == 0 && i != 0)
				j += 3;
			dictionary.put(moves.get(i), j);
		}
	}

	@Override
	public void task1(String line) {
		score += (int) line.charAt(2) - 87;
		score += dictionary.get(line);
	}

	@Override
	public void task2(String line) {
		String s = (String) dictionary.keySet().toArray()[strats.indexOf(line)];

		score += ((int) s.charAt(2) - 87) + dictionary.get(s);
	}

	@Override
	public Object getResult(int task) {
		return score;
	}

}
