package main;

import java.util.HashMap;
import java.util.Map;

public class TestClass {

	static int i;
	static int currentIndex = 0;
	
	private static void test(int index, char[] chars) {
		Map<Character, Integer> map = new HashMap<>();
		boolean hasDuplicate = false;
		
		for (i = index; i < index + 14; i++) {
			if (!map.containsKey(chars[i])) {
				map.put(chars[i], 1);
			} else {
				hasDuplicate = true;
				break;
			}
		}
		
		if (hasDuplicate) test(index + 1, chars);
	}
	
	public static void main(String[] args) {
		String l = "";
		if (l.isEmpty())
		System.out.println("yes");
	}

}
