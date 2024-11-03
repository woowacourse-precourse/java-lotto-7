package lotto.domains.lotto;

import java.util.List;

public class LottoPrizeNumbers {
	private List<Integer> winningNumbers;
	private int bonusNumber;

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
