package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
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
