package lotto.domain;

import java.util.List;
import java.util.Optional;

import lotto.domain.enums.Rank;

public class WinningLotto extends Lotto {
	public WinningLotto(List<Integer> numbers) {
		super(numbers);
	}

	public Optional<Rank> calculateRank(Lotto lotto, BonusNumber bonusNumber) {
		int winCount = getWinCount(lotto);
		boolean bonusWin = isBonusWin(lotto, bonusNumber);

		return Rank.judgeBy(winCount, bonusWin);
	}

	private int getWinCount(Lotto lotto) {
		int matchCount = 0;

		for (Integer number : this.getNumbers()) {
			if (lotto.containNumber(number)) {
				matchCount++;
			}
		}

		return matchCount;
	}

	private boolean isBonusWin(Lotto lotto, BonusNumber bonusNumber){
		return lotto.containNumber(bonusNumber.getNumber());
	}
}
