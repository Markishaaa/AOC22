package day10;

import utils.Task;

public class TaskD10 implements Task {

	private int cycle = 0;
	private int x = 1;
	private int signalStrengthSum = 0;
	private int cycleNum = 20;

	private String[] crt = new String[6];
	private int[] crtRows = { 40, 80, 120, 160, 200, 240 };
	
	public TaskD10() {
		for (int i = 0; i < crt.length; i++)
			crt[i] = "";
	}

	private void executeCommand(String command, boolean show) {
		cycle++;

		createDisplay(show);
		checkCycle();
		
		if (command.equals("noop"))
			return;

		cycle++;
		
		createDisplay(show);
		checkCycle();
		
		x += Integer.parseInt(command.split(" ")[1]);
	}
	
	private void createDisplay(boolean show) {
		if (!show) return;
		
		int r = setRow();
		crt[r] += setPixel(r);
	}
	
	private String printDisplay() {
		String display = "\n\n";
		for (String row : crt) {
			display += row + "\n";
		}
		
		return display;
	}

	private int setRow() {
		for (int i = 0; i < crtRows.length; i++) {
			if (cycle <= crtRows[i]) {
				return i;
			}
		}

		return -1;
	}
	
	private String setPixel(int r) {
		if (crt[r].length() >= x - 1 && crt[r].length() <= x + 1)
			return "#";
		return ".";
	}

	private void checkCycle() {
		if (cycle == cycleNum) {
			int signalStrength = cycle * x;
			signalStrengthSum += signalStrength;

			cycleNum += 40;
		}
	}

	@Override
	public void task1(String line) {
		executeCommand(line, false);
	}

	@Override
	public void task2(String line) {
		executeCommand(line, true);
	}

	@Override
	public Object getResult(int task) {
		if (task == 1)
			return signalStrengthSum;
		
		return printDisplay();
	}

}
