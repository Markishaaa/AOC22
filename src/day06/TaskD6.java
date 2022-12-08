package day06;

import java.util.HashMap;
import java.util.Map;

public class TaskD6 {

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
	
	public int findIndex(String line, int task) {
		char[] chars =  line.trim().toCharArray();
		int charNum = task == 1 ? 4 : 14;
		
		checkPackets(0, chars, charNum);
		
		return i;
	}

}
