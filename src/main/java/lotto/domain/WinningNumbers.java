package lotto.domain;

import static lotto.common.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {

	private final List<Integer> winningNumbers;
	private final int bonusNumber;

	public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
		validateWinningNumbersSize(winningNumbers);
		validateWinningNumbersRange(winningNumbers);
		validateDuplicatedWinningNumbers(winningNumbers);
		validateBonusNumberRange(bonusNumber);
		validateWinningNumbersContainsBonusNumber(bonusNumber, winningNumbers);

		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public static WinningNumbers of(List<Integer> winningNumbers, int bonusNumber) {
		return new WinningNumbers(winningNumbers, bonusNumber);
	}

	private void validateWinningNumbersSize(List<Integer> winningNumbers) {
		if (winningNumbers.size() != LottoInfo.SIZE.getInfo()) {
			throw new IllegalArgumentException(OVER_FLOW_WINNING_NUMBERS_SIZE.getComment());
		}
	}

	private void validateDuplicatedWinningNumbers(List<Integer> winningNumbers) {
		HashSet<Integer> winningNumbersSet = new HashSet<>(winningNumbers);

		if (winningNumbersSet.size() != winningNumbers.size()) {
			throw new IllegalArgumentException(DUPLICATION_WINNING_NUMBERS.getComment());
		}
	}

	private void validateWinningNumbersRange(List<Integer> winningNumbers) {
		boolean hasOverFlowRangeNumber = winningNumbers.stream()
			.anyMatch(winningNumber ->
				winningNumber < LottoInfo.MIN_NUMBER.getInfo() || LottoInfo.MAX_NUMBER.getInfo() < winningNumber);

		if (hasOverFlowRangeNumber) {
			throw new IllegalArgumentException(OVER_FLOW_WINNING_NUMBER_RANGE.getComment());
		}
	}

	private void validateBonusNumberRange(int bonusNumber) {
		if (bonusNumber < LottoInfo.MIN_NUMBER.getInfo() || LottoInfo.MAX_NUMBER.getInfo() < bonusNumber) {
			throw new IllegalArgumentException(OVER_FLOW_BONUS_NUMBER_RANGE.getComment());
		}
	}

	private void validateWinningNumbersContainsBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
		if (winningNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(DUPLICATION_BONUS_NUMBER_IN_WINNING_NUMBERS_NUMBERS.getComment());
		}
	}

	public boolean doesWinningNumbersContains(int lottoNumber) {
		return winningNumbers.contains(lottoNumber);
	}

	public boolean isBonusNumberContainedIn(List<Integer> lottoNumbers) {
		return lottoNumbers.contains(bonusNumber);
	}

}
