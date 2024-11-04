package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		checkForDuplicates(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
		}
	}

	private void checkForDuplicates(List<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			checkIfDuplicate(numbers, numbers.get(i), i);
		}
	}

	private void checkIfDuplicate(List<Integer> numbers, Integer number, int index) {
		for (int j = 0; j < index; j++) {
			if (numbers.get(j).equals(number)) {
				throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
			}
		}

	}
}
