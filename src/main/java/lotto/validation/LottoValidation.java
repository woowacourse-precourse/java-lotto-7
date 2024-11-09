package lotto.validation;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;
import static lotto.domain.enums.Error.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidation {

	public static int parseAmount(String input) {
		validateNumberFormat(input);
		int amount = Integer.parseInt(input);
		validatePurchaseAmount(amount);

		return amount;
	}

	public static List<Integer> parseNumbers(String input) {
		List<Integer> numbers = stream(input.split(","))
			.map(Integer::parseInt)
			.collect(toList());

		validateLottoNumbers(numbers);
		checkForDuplicateNumbers(numbers);

		return numbers;
	}

	public static int parseBonusNumber(String input, List<Integer> winningNumbers) {
		validateNumberFormat(input);
		int bonusNumber = Integer.parseInt(input);
		validateBonusNumber(bonusNumber, winningNumbers);

		return bonusNumber;
	}

	public static void validatePurchaseAmount(int amount) {
		if (amount % 1000 != 0) {
			throw new IllegalArgumentException(INVALID_AMOUNT.getMessage());
		}
	}

	public static void validateLottoNumbers(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(INVALID_WINNING_NUMBER.getMessage());
		}
	}

	public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
		if (bonusNumber < 1 || bonusNumber > 45) {
			throw new IllegalArgumentException(INVALID_BONUS_NUMBER.getMessage());
		}

		if (winningNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
		}
	}

	public static void checkForDuplicateNumbers(List<Integer> numbers) {
		Set<Integer> uniqueNumbers = new HashSet<>(numbers);

		if (uniqueNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
		}
	}

	public static void validateNumberFormat(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
		}
	}
}
