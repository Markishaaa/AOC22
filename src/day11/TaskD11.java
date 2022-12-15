package day11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import utils.Task;

public class TaskD11 implements Task {

	private List<Monkey> monkeys = new ArrayList<>();
	private List<String> lines = new ArrayList<>();

	private int globalModulo = 1;

	private void loadMonkey() {
		List<Long> items = new ArrayList<>();
		String[] itemsArr = lines.get(1).substring(18).split(",");
		for (int i = 0; i < itemsArr.length; i++) {
			items.add(Long.parseLong(itemsArr[i].trim()));
		}

		String operation = lines.get(2).substring(23, 24);
		String worryNum = lines.get(2).substring(25);
		int worryLvl = 0;
		boolean old = false;
		if (worryNum.equals("old")) {
			old = true;
		} else {
			worryLvl = Integer.parseInt(lines.get(2).substring(25));
		}

		int testNum = Integer.parseInt(lines.get(3).substring(21));

		int[] monkeyIs = new int[2];
		monkeyIs[0] = Integer.parseInt(lines.get(4).substring(29));
		monkeyIs[1] = Integer.parseInt(lines.get(5).substring(30));

		Monkey m = new Monkey(items, worryLvl, testNum, monkeyIs, operation, old);
		monkeys.add(m);

		lines.clear();
	}

	private void round(int task) {
		for (Monkey monkey : monkeys) {
			for (long item : monkey.getItems()) {

				long inspectItem;
				if (monkey.isOld())
					inspectItem = item; 
				else
					inspectItem = monkey.getWorryLevel();
				
				long worryLvl = monkey.inspect(item, inspectItem);
				
				if (task == 2) 
					worryLvl %= globalModulo;
				else
					worryLvl /= 3;	

				int monkeyI = monkey.test(item, worryLvl);

				monkeys.get(monkeyI).getItems().add(worryLvl);
			}

			monkey.getItems().clear();
		}
	}

	@Override
	public void task1(String line) {
		if (line.isEmpty())
			return;
		if (line.contains("If false")) {
			lines.add(line);
			loadMonkey();
			return;
		}
		lines.add(line);
	}

	@Override
	public void task2(String line) {
		task1(line);
	}

	@Override
	public Object getResult(int task) {
		int numOfRounds = 0;
		if (task == 1) {
			numOfRounds = 20;
		} else {
			numOfRounds = 10_000;
			globalModulo = monkeys.stream().map(m -> m.getTestNumber()).reduce(1, (a, b) -> a * b);
		}

		for (int i = 0; i < numOfRounds; i++) {
			round(task);
		}

		monkeys.stream().map(Monkey::getInspectCount).forEach(System.out::println);

		List<Integer> mostInspected = monkeys.stream().map(Monkey::getInspectCount).sorted(Comparator.reverseOrder())
				.limit(2).collect(Collectors.toList());

		return (long) mostInspected.get(0) * mostInspected.get(1);
	}

}
