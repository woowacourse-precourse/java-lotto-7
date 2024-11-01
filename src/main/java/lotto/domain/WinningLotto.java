package lotto.domain;

import static lotto.constant.ExceptionMessage.BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.constant.RankPrice;

public class WinningLotto {

    private final Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setupBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER.getMessage());
        }
    }

    public RankPrice getRank(Lotto target) {
        List<Integer> targetNumbers = target.getNumbers();
        boolean matchBonus = false;
        Set<Integer> set = new HashSet<>();
        set.addAll(lotto.getNumbers());
        int matchCount = (int)targetNumbers.stream()
            .filter(number -> !set.add(number))
            .count();
        if (!set.add(bonusNumber)) {
            matchBonus = true;
        }
        return RankPrice.of(matchCount, matchBonus);
    }
}
