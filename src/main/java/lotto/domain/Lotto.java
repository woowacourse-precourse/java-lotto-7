package lotto.domain;

import static lotto.global.ErrorMessage.*;
import static lotto.global.LottoConstant.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
		}

		Set<Integer> uniqueNumbers = new HashSet<>(numbers);
		if (uniqueNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException(NOT_DUPLICATE_LOTTO_NUMBER.getMessage());
		}

		boolean hasOutOfRangeNumber = numbers.stream()
			.anyMatch(number -> number < LOTTO_MINIMUM_NUMBER || number > LOTTO_MAXIMUM_NUMBER);

		if(hasOutOfRangeNumber){
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
		}
	}

	public List<Integer> getNumbers(){
		return numbers;
	}

	public boolean containNumber(Integer number) {
		return numbers.contains(number);
	}
}
