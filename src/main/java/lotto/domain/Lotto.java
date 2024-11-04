package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		validateDuplicate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		Set<Integer> validateNumbers = new HashSet<>(numbers);
		if (validateNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
		}
	}

	public int getWinningNumbersCount(Set<Integer> winningNumbers) {
		return (int)numbers.stream()
			.filter(winningNumbers::contains)
			.count();
	}

	public boolean hasBonusNumber(int bonusNumber) {
		return numbers.contains(bonusNumber);
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
