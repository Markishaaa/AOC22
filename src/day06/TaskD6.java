package day06;

import java.util.HashMap;
import java.util.Map;

import utils.Task;

public class TaskD6 implements Task {

	private int i = 0;

	private void checkPackets(int index, char[] chars, int charNum) {
		Map<Character, Integer> map = new HashMap<>();
		boolean hasDuplicate = false;

		for (i = index; i < index + charNum; i++) {
			if (!map.containsKey(chars[i])) {
				map.put(chars[i], 1);
			} else {
				hasDuplicate = true;
				break;
			}
		}

		if (hasDuplicate)
			checkPackets(index + 1, chars, charNum);
	}
	
	public void findIndex(String line, int charNum) {
		char[] chars =  line.trim().toCharArray();
		
		checkPackets(0, chars, charNum);
		
		return;
	}
	
	@Override
	public void task1(String line) {
		findIndex(line, 4);
	}

	@Override
	public void task2(String line) {
		findIndex(line, 14);
	}

	@Override
	public Object getResult(int task) {
		return i;
	}

}
