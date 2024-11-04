package lotto.domain;

import static lotto.validation.LottoValidation.*;

import java.util.List;

import lotto.domain.enums.Prize;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateLottoNumbers(numbers);
		checkForDuplicateNumbers(numbers);
		this.numbers = numbers.stream().sorted().toList();
	}

	public int countMatchingNumbers(List<Integer> winningNumbers) {
		return (int)winningNumbers.stream().filter(numbers::contains).count();
	}

	public Prize calculateMatchResult(List<Integer> winningNumbers, int bonusNumber) {
		int matchCount = countMatchingNumbers(winningNumbers);
		boolean bonusMatch = numbers.contains(bonusNumber);

		return Prize.valueOf(matchCount, bonusMatch);
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
