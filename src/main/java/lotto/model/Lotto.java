package lotto.model;

import java.util.List;

import lotto.validation.ValidateLotto;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		ValidateLotto.validateLottoNumbers(numbers);
		this.numbers = numbers;
	}
	
	public List<Integer> getNumbers() {
		return numbers;
	}
}
