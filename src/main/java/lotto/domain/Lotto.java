package lotto.domain;

import static lotto.validation.LottoValidation.*;

import java.util.List;

import lotto.domain.enums.Rank;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateLottoNumbers(numbers);
		checkForDuplicateNumbers(numbers);
		this.numbers = numbers.stream().sorted().toList();
	}
}
