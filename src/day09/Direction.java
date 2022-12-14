package day09;

enum Direction {

	UP ("U"),
	DOWN ("D"),
	LEFT ("L"),
	RIGHT ("R");

	private final String dir;
	Direction(String dir) {
		this.dir = dir;
	}
	
	public String value() {
		return dir;
	}
	
}
