package lotto.io.input.validation;

import static lotto.common.ErrorMessage.*;

import java.util.Arrays;
import java.util.regex.Pattern;

import lotto.domain.LottoInfo;

public class UserInputValidation {

	private static final Pattern PURCHASE_AMOUNT_VALIDATION_PATTERN = Pattern.compile("^[1-9]\\d*$");
	private static final Pattern LOTTO_NUMBER_RANGE_VALIDATION_PATTERN = Pattern.compile("^0*([1-9]|[1-3]\\d|4[0-5])$");

	public void validatePurchaseAmount(String purchaseAmount) {
		if (!PURCHASE_AMOUNT_VALIDATION_PATTERN.matcher(purchaseAmount).matches()) {
			throw new IllegalArgumentException(NOT_NATURAL_NUMBER_PURCHASE_AMOUNT.getComment());
		}
	}

	public void validateWinningNumbersDelimiter(String inputWinningNumbers, String delimiter) {
		if (!inputWinningNumbers.contains(delimiter)) {
			throw new IllegalArgumentException(NOT_USE_DELIMITER_IN_WINNING_NUMBERS.getComment());
		}
	}

	public void validateWinningNumbers(String[] splitWinningNumbers) {
		validateWinningNumberSize(splitWinningNumbers);
		validateDuplicatedWinningNumbers(splitWinningNumbers);
		validateWinningNumberRange(splitWinningNumbers);
	}

	private void validateWinningNumberSize(String[] splitWinningNumbers) {
		int count = (int)Arrays.stream(splitWinningNumbers)
			.filter(number -> !number.isBlank())
			.count();

		if (count != LottoInfo.SIZE.getInfo()) {
			throw new IllegalArgumentException(OVER_FLOW_WINNING_NUMBERS_SIZE.getComment());
		}
	}

	private void validateDuplicatedWinningNumbers(String[] splitWinningNumbers) {
		int winningNumberCountWithoutDuplication = (int)Arrays.stream(splitWinningNumbers)
			.map(String::trim)
			.distinct()
			.count();

		if (winningNumberCountWithoutDuplication != splitWinningNumbers.length) {
			throw new IllegalArgumentException(DUPLICATION_WINNING_NUMBERS.getComment());
		}
	}

	private void validateWinningNumberRange(String[] splitWinningNumbers) {
		boolean hasWrongWinningNumber = Arrays.stream(splitWinningNumbers)
			.map(String::trim)
			.anyMatch(winningNumber -> !LOTTO_NUMBER_RANGE_VALIDATION_PATTERN.matcher(winningNumber).matches());

		if (hasWrongWinningNumber) {
			throw new IllegalArgumentException(OVER_FLOW_WINNING_NUMBER_RANGE.getComment());
		}
	}

	public void validateBonusNumberRange(String bonusNumber) {
		if (!LOTTO_NUMBER_RANGE_VALIDATION_PATTERN.matcher(bonusNumber).matches()) {
			throw new IllegalArgumentException(OVER_FLOW_BONUS_NUMBER_RANGE.getComment());
		}
	}

}
