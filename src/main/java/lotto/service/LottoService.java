package lotto.service;

import java.util.List;
import java.util.regex.Pattern;

import lotto.domains.lotto.constant.LottoNumberConstant;
import lotto.exception.ExceptionMessage;
import lotto.util.Spliter;
import lotto.util.TypeConverter;

public class LottoService {
	private static final String WINNING_NUMBER_REGEX = "^\\d+(,\\d+)*\\d$";
	public List<Integer> drawWinningNumbers(String winningNumbers) {
		validateWinningNumberRegex(winningNumbers);
		return saveWinningNumbers(winningNumbers);
	}

	public int drawBonusNumber(String rawBonusNumber, List<Integer> winningNumbers) {
		int bonusNumber = TypeConverter.convertStringToInteger(rawBonusNumber);
		validateIsDuplicateByWinningNumber(bonusNumber, winningNumbers);
		return bonusNumber;
	}

	private void validateIsDuplicateByWinningNumber(int bonusNumber, List<Integer> winningNumbers) {
		if (winningNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_IS_DUPLICATED.toString());
		}
	}

	private List<Integer> saveWinningNumbers(String winningNumbers) {
		List<String> splittedWinningNumbers = Spliter.splitByComma(winningNumbers);
		validateNumberSize(splittedWinningNumbers.size());
		return splittedWinningNumbers.stream()
			.map(TypeConverter::convertStringToInteger)
			.toList();
	}

	private void validateWinningNumberRegex(String winningNumbers) {
		if (Pattern.matches(winningNumbers, WINNING_NUMBER_REGEX)) {
			throw new IllegalArgumentException(ExceptionMessage.MISMATCHED_REGEX.toString());
		}
	}

	private void validateNumberSize(int size) {
		if (size != LottoNumberConstant.LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_SIZE.toString());
		}
	}
}
