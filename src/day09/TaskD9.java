package day09;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utils.Task;

public class TaskD9 implements Task {

	Position[] rope1 = new Position[2];
	Position[] rope2 = new Position[10];

	private List<String> tails;

	public TaskD9() {
		for (int i = 0; i < rope2.length; i++)
			rope2[i] = new Position();

		for (int i = 0; i < rope1.length; i++)
			rope1[i] = new Position();

		this.tails = new ArrayList<>();
		// starting position
//		this.tails.add(rope1[1].x + "," + rope1[1].y);
	}

	private void turn2(String dir, int steps, Position[] rope) {
		for (int j = 0; j < steps; j++) {
			for (int i = 1; i < rope.length; i++) {
				if (dir.equals(Direction.UP.value())) {
					if (i == 1)
						rope[0].y++;

					if (rope[i].y + 1 < rope[i - 1].y)
						upper(i, rope);
				} else if (dir.equals(Direction.DOWN.value())) {
					if (i == 1)
						rope[0].y--;

					if (rope[i].y - 1 > rope[i - 1].y)
						lower(i, rope);
				} else if (dir.equals(Direction.RIGHT.value())) {
					if (i == 1)
						rope[0].x++;

					if (rope[i].x + 1 < rope[i - 1].x)
						right(i, rope);
				} else {
					if (i == 1)
						rope[0].x--;

					if (rope[i].x - 1 > rope[i - 1].x)
						left(i, rope);
				}
				tails.add(rope[rope.length - 1].x + "," + rope[rope.length - 1].y);
			}
		}
	}
	
	private void upper(int i, Position[] rope) {
		if (rope[i].x < rope[i - 1].x)
			rope[i].x++;
		else if (rope[i].x > rope[i - 1].x)
			rope[i].x--;

		rope[i].y++;
	}

	private void lower(int i, Position[] rope) {
		if (rope[i].x > rope[i - 1].x)
			rope[i].x--;
		else if (rope[i].x < rope[i - 1].x)
			rope[i].x++;

		rope[i].y--;
	}

	private void right(int i, Position[] rope) {
		if (rope[i].y < rope[i - 1].y)
			rope[i].y++;
		else if (rope[i].y > rope[i - 1].y)
			rope[i].y--;

		rope[i].x++;
	}

	private void left(int i, Position[] rope) {
		if (rope[i].y > rope[i - 1].y)
			rope[i].y--;
		else if (rope[i].y < rope[i - 1].y)
			rope[i].y++;

		rope[i].x--;
	}

	@Override
	public void task1(String line) {
		String[] i = line.split(" ");
		turn2(i[0], Integer.parseInt(i[1]), rope1);
	}

	@Override
	public void task2(String line) {
		String[] i = line.split(" ");
		turn2(i[0], Integer.parseInt(i[1]), rope2);
	}

	@Override
	public Object getResult(int task) {
		System.out.println(tails.stream().distinct().collect(Collectors.toList()));
		return tails.stream().distinct().count();
	}

}
