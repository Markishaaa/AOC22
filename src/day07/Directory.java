package day07;

import java.util.ArrayList;
import java.util.List;

class Directory {

	private String name;
	private List<Directory> directories;
	private List<File> files;
	private Directory parent;

	public Directory(String name) {
		this.name = name;
		this.files = new ArrayList<>();
		this.directories = new ArrayList<>();
	}
	
	public Directory findByName(String name) {
		for (int i = 0; i < directories.size(); i++) {
			if (directories.get(i).getName().equals(name)) {
				return directories.get(i);
			}
		}

		return null;
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

	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}
	
	public int getSize() {
		int sum = 0;
		for (File f : files) {
			sum += f.getSize();
		}
		
		for (Directory d : directories) {
			sum += d.getSize();
		}
		
		return sum;
	}

	@Override
	public String toString() {
		String s = "- " + name + " ( " + files + " ) = " + getSize();
		for (Directory d : directories) {
			s += "\n" + d;
		}
		return s;
	}
	
}