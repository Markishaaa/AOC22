package main;

import java.io.File;
import java.util.Scanner;

import day01.TaskD1;
import day02.TaskD2;
import day03.TaskD3;
import day04.TaskD4;
import day05.TaskD5;
import day06.TaskD6;
import day07.TaskD7;

public class ReadFiles {

	private static int dayNum = 7;
	private static int taskNum = 1;
	private String file;

	TaskD1 d1 = new TaskD1();
	TaskD2 d2 = new TaskD2();
	TaskD3 d3 = new TaskD3();
	TaskD4 d4 = new TaskD4();
	TaskD5 d5 = new TaskD5();
	TaskD6 d6 = new TaskD6();
	TaskD7 d7 = new TaskD7();

	public ReadFiles() {
		this.file = "res/input" + dayNum + ".txt";
//		this.file = "res/input-test.txt";
	}

	private Object readFile() {

		try {
			File myObj = new File(file);
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();

				int multiplier = taskNum == 1 ? 0 : 100;
				switch (dayNum + multiplier) {
				case 1, 101:
					this.d1.task(line);
					break;
				case 2:
					this.d2.taskOne(line);
					break;
				case 102:
					this.d2.taskTwo(line);
					break;
				case 3:
					this.d3.findCommonChars(line);
					break;
				case 103:
					this.d3.findCommonBadges(line);
					break;
				case 4:
					this.d4.findContains(line);
					break;
				case 104:
					this.d4.findOverlaps(line);
					break;
				case 5, 105:
					this.d5.moveCrates(line, taskNum);
					break;
				case 6, 106:
					return this.d6.findIndex(line, taskNum);
				case 7:
					this.d7.isCommand(line);
				}

			}

			myReader.close();

			switch (dayNum) {
			case 1:
				return this.d1.getAnswer(taskNum);
			case 2:
				return this.d2.getScore();
			case 3:
				return this.d3.getSum();
			case 4:
				return this.d4.getCount();
			case 5:
				return this.d5.getTopCrates();
			case 7:
				return this.d7.sizes();
			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return 0;
	}

	public static void main(String[] args) {
		ReadFiles rf = new ReadFiles();
		Object answer;

		answer = rf.readFile();

		System.out.println("Day " + dayNum + ": Task " + taskNum + "\n");
		System.out.println("Answer: " + answer);
	}

}
