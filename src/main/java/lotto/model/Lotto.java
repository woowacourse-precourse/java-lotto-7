package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateSize(numbers);
		validateRange(numbers);
		validateDuplicates(numbers);
		this.numbers = numbers;
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
		}
	}

	private void validateRange(List<Integer> numbers) {
		if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
		}
	}

	private void validateDuplicates(List<Integer> numbers) {
		Set<Integer> uniqueNumbers = new HashSet<>(numbers);
		if (uniqueNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
		}
	}
}
