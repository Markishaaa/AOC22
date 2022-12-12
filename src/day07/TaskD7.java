package day07;

import java.util.ArrayList;
import java.util.List;

import utils.Task;

public class TaskD7 implements Task {

	private List<Directory> directories = new ArrayList<>();
	private int currentDirectoryIndex;
	
	private int totalSizes = 0;
	private final int maxSize = 100000;

	private void fillDirectories() {
		for (int i = directories.size() - 1; i >= 0; i--) {
			for (Directory d : directories) {
				int id = d.findByName(directories.get(i).getName());
				if (id >= 0) {
					d.getDirectories().set(id, directories.get(i));
				}
			}
		}
	}

	public int sizes() {
		fillDirectories();
		for (Directory d : directories) {
			for (Directory d1 : d.getDirectories())
				totalSizes += d1.getSize();
			int size = d.getSize();
			if (size <= maxSize) {
				System.out.println(d.getName() + ": " + size);
				
				totalSizes += size;
			}
		}
		
		return totalSizes;
	}

	public void isCommand(String l) {
		if (l.contains("$ cd")) {
			executeCommand(l);
		} else {
			list(l);
		}
	}

	private void executeCommand(String l) {
		String command = l.substring(2);

		if (command.contains("cd")) {

			String dirName = command.substring(3);
			if (!dirName.equals("..")) {
				Directory d = new Directory(dirName);
				directories.add(d);

				currentDirectoryIndex = directories.size() - 1;
			} else {
				currentDirectoryIndex -= 1;
			}

		}
	}

	private void list(String l) {
		if (l.contains("$"))
			return;

		if (l.substring(0, 3).equals("dir")) {
			String dirName = l.substring(4);
			Directory d = new Directory(dirName);
			directories.get(currentDirectoryIndex).getDirectories().add(d);
		} else {
			String[] data = l.split(" ");
			int size = Integer.parseInt(data[0]);

			String type = "";
			if (data[1].contains(".")) {
				String[] data1 = data[1].split("\\.");
				type = data1[1];
			}
			String fileName = data[1];

			File f;
			if (type.isEmpty())
				f = new File(fileName, size);
			else
				f = new File(fileName, type, size);

			directories.get(currentDirectoryIndex).getFiles().add(f);
		}
	}

	@Override
	public void task1(String line) {
		isCommand(line);
	}

	@Override
	public void task2(String line) {
		
	}

	@Override
	public Object getResult(int task) {
		return null;
	}

}