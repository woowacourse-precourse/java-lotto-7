package lotto.domains.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.domains.lotto.constant.LottoNumberConstant;
import lotto.exception.ExceptionMessage;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private static void validate(List<Integer> numbers) {
		validateLottoSize(numbers);
		validateLottoNumberIsDuplicated(numbers);
		validateLottoNumberBoundary(numbers);
	}

	private static void validateLottoSize(List<Integer> numbers) {
		if (numbers.size() != LottoNumberConstant.LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_SIZE.toString());
		}
	}

	private static void validateLottoNumberIsDuplicated(List<Integer> numbers) {
		Set<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
		if (nonDuplicatedNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_IS_DUPLICATED.toString());
		}
	}

	private static void validateLottoNumberBoundary(List<Integer> numbers) {
		numbers.forEach(number -> {
			if (number < LottoNumberConstant.LOTTO_MINIMUM_NUMBER
				|| number > LottoNumberConstant.LOTTO_MAXIMUM_NUMBER) {
				throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_IS_OUT_OF_BOUND.toString());
			}
		});
	}

}
