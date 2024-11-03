package lotto.domains.lotto.domain;

import java.util.List;

public class LottoPrizeNumbers {
	private final List<Integer> winningNumbers;
	private final int bonusNumber;

	private LottoPrizeNumbers(List<Integer> winningNumbers, int bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public static LottoPrizeNumbers of(List<Integer> winningNumbers, int bonusNumber) {
		return new LottoPrizeNumbers(winningNumbers, bonusNumber);
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
