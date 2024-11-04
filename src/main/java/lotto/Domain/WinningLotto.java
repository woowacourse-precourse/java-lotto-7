package lotto.Domain;

import java.util.List;
import lotto.Enum.LottoPrizeRank;
import lotto.Messages.ErrorMessages;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validateBonusNumber(numbers, bonusNumber);
        this.lotto = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.BONUS_RANGE.message);
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.BONUS_DUPLICATE.message);
        }
    }

    public LottoPrizeRank match(Lotto userLotto) {
        int matchCount = userLotto.matchNumbers(lotto.getNumbers());
        boolean bonusMatch = userLotto.containsNumber(bonusNumber);
        return LottoPrizeRank.getRank(matchCount, bonusMatch);
    }
}
