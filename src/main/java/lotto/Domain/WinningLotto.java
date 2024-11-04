package lotto.Domain;

import java.util.List;
import lotto.Enum.LottoPrizeRank;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.lotto = new Lotto(winningNumbers);
        validateBonusNumber(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        LottoValidator.validateBonusNumber(bonusNumber, winningNumbers);
    }

    public LottoPrizeRank match(Lotto userLotto) {
        int matchCount = userLotto.matchNumbers(lotto.getNumbers());
        boolean matchBonus = matchCount == 5 && userLotto.containsNumber(bonusNumber);

        return calculatePrizeRank(matchCount, matchBonus);
    }

    private LottoPrizeRank calculatePrizeRank(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return LottoPrizeRank.FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return LottoPrizeRank.SECOND;
        }
        if (matchCount == 5) {
            return LottoPrizeRank.THIRD;
        }
        if (matchCount == 4) {
            return LottoPrizeRank.FOURTH;
        }
        if (matchCount == 3) {
            return LottoPrizeRank.FIFTH;
        }
        return LottoPrizeRank.MISS;
    }
}
}
