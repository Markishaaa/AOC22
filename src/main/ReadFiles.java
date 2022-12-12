package main;

import java.io.File;
import java.util.Scanner;

import utils.Days;
import utils.Task;

public class ReadFiles {

	private static boolean test = false;
	private static int dayNum = 7;
	private static int taskNum = 2;
	
	private String file;

	Task d;

	public ReadFiles() {
		if (test)
			this.file = "res/input-test.txt";
		else
			this.file = "res/input" + dayNum + ".txt";
		
		this.d = Days.valueOf("DAY" + dayNum).createTask();
	}

	private Object readFile() {

		try {
			File myObj = new File(file);
			Scanner myReader = new Scanner(myObj);
			
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();

				switch(taskNum) {
				case 1:
					d.task1(line);
					break;
				case 2:
					d.task2(line);
				}
			}

			myReader.close();

			return d.getResult(taskNum);
			
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
