package day07;

public class File {

	private String name;
	private String type;
	private int size;

	public File(String name, String type, int size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}

	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "File [name=" + name + ", size=" + size + "]";
	}

}
