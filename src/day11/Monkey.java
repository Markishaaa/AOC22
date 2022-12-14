package day11;

import java.util.Arrays;
import java.util.List;

class Monkey {

	private List<Integer> items;
	private String operation;
	private int worryLevel;
	private boolean old;
	private int testNumber;
	private int[] monkeyIs;
	
	private int inspectCount;

	public Monkey(List<Integer> items, int worryLevel, int testNumber, int[] monkeyIs, String operation,
			boolean old) {
		super();
		this.items = items;
		this.worryLevel = worryLevel;
		this.testNumber = testNumber;
		this.monkeyIs = monkeyIs;
		this.old = old;
		this.operation = operation;
		
		this.inspectCount = 0;
	}

	public int inspect(int item, int worryLvl) {
		increaseInspectCount();
		int lvl;
		if (operation.equals("*"))
			lvl = item * worryLvl;
		else
			lvl = item + worryLvl;
		
		return lvl / 3;
	}

	public int test(int item, int lvl) {
		if (lvl % testNumber == 0)
			return monkeyIs[0];

		return monkeyIs[1];
	}

	public List<Integer> getItems() {
		return items;
	}

	public int getWorryLevel() {
		return worryLevel;
	}

	public void setWorryLevel(int inspectWorryLevel) {
		this.worryLevel = inspectWorryLevel;
	}

	public int getTestNumber() {
		return testNumber;
	}

	public void setTestNumber(int testNumber) {
		this.testNumber = testNumber;
	}

	public int[] getMonkeyIs() {
		return monkeyIs;
	}

	public boolean isOld() {
		return old;
	}

	public String getOperation() {
		return operation;
	}
	
	private void increaseInspectCount() {
		inspectCount++;
	}
	
	public int getInspectCount() {
		return inspectCount;
	}

	@Override
	public String toString() {
		return "Monkey [items=" + items + ", worryLevel=" + worryLevel + ", testNumber=" + testNumber
				+ ", monkeyIs=" + Arrays.toString(monkeyIs) + "]";
	}

}
