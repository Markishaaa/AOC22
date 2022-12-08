package day07;

import java.util.ArrayList;
import java.util.List;

public class Directory {

	private String name;
	private List<Directory> directories;
	private List<File> files;
	private int size;

	public Directory(String name) {
		this.name = name;
		this.files = new ArrayList<>();
		this.directories = new ArrayList<>();
	}

	public int findByName(String name) {
		for (int i = 0; i < directories.size(); i++) {
			if (directories.get(i).getName().equals(name)) {
				return i;
			}
		}

		return -1;
	}

	public int getSize() {
		if (!files.isEmpty()) {
			for (File f : files) {
				size += f.getSize();
			}
		}

		if (!directories.isEmpty()) {
			for (Directory d : directories) {
				if (!d.files.isEmpty()) {
					for (File f : d.files) {
						size += f.getSize();
					}
				}
			}
		}

		return size;
	}

	public String getName() {
		return name;
	}

	public List<File> getFiles() {
		return files;
	}

	public List<Directory> getDirectories() {
		return directories;
	}

	public void setDirectories(List<Directory> directories) {
		this.directories = directories;
	}

	@Override
	public String toString() {
		return "Directory [name=" + name + ", directories=" + directories + ", files=" + files + "]";
	}

}
