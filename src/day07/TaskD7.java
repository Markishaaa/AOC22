package day07;

import utils.Task;

public class TaskD7 implements Task {

	private Directory root;
	private Directory current;
	private boolean isLs = false;

	private final int maxSize = 100_000;
	private int sumOfSmallest = 0;

	private final int maxDiskSpace = 70_000_000;
	private final int minUpdateSpace = 30_000_000;

	private int getSumOfSizes(Directory dir) {
		int size = dir.getSize();

		if (size < maxSize)
			sumOfSmallest += size;

		for (Directory d : dir.getDirectories()) {
			getSumOfSizes(d);
		}

		return sumOfSmallest;
	}

	private int min = Integer.MAX_VALUE;
	private int getSmallest(Directory dir, int freeSpace) {
		int size = dir.getSize();
		
		if (size + freeSpace >= minUpdateSpace) {
			if (min > size) {
				min = size;
			}
		}

		for (Directory d : dir.getDirectories()) {
			getSmallest(d, freeSpace);
		}
		
		return min;
	}

	private void check(String line) {
		if (line.contains("$ cd")) {
			isLs = false;

			String dirName = line.substring(5);
			if (dirName.equals("/")) {
				root = new Directory(dirName);
				root.setParent(null);
				current = root;
			} else if (dirName.equals("..")) {
				current = current.getParent();
			} else {
				current = current.findByName(dirName);
			}
		} else if (line.equals("$ ls")) {
			isLs = true;
			return;
		}

		if (isLs)
			list(line);
	}

	private void list(String line) {
		if (line.substring(0, 3).equals("dir")) {
			String dirName = line.substring(4);
			Directory d = new Directory(dirName);
			d.setParent(current);
			current.getDirectories().add(d);
		} else {
			int size = Integer.parseInt(line.split(" ")[0]);
			String[] file = line.split(" ")[1].split("\\.");
			File f;
			if (file.length == 1)
				f = new File(file[0], size);
			else
				f = new File(file[0] + "." + file[1], file[1], size);
			current.getFiles().add(f);
		}
	}

	@Override
	public void task1(String line) {
		check(line);
	}

	@Override
	public void task2(String line) {
		check(line);
	}

	@Override
	public Object getResult(int task) {
//		System.out.println(root);
		if (task == 1)
			return getSumOfSizes(root);

		int space = maxDiskSpace - root.getSize();
		
		return getSmallest(root, space);
	}

}