package lotto.domain;

import java.util.List;
import static lotto.constants.Constants.*;

public class WinningLotto {
	private final Lotto winningLotto;
	private final int bonusNumber;

	public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
		this.winningLotto = new Lotto(winningNumbers);
		validateBonusNumber(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	public LottoRank calculateRank(Lotto lotto) {
		int matchCount = lotto.countMatchingNumbers(winningLotto.getNumbers());
		boolean matchBonus = lotto.containsBonusNumber(bonusNumber);
		return LottoRank.valueOf(matchCount, matchBonus);
	}

	private void validateBonusNumber(int bonusNumber) {
		if (winningLotto.getNumbers().contains(bonusNumber)) {
			throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR);
		}
	}
}
