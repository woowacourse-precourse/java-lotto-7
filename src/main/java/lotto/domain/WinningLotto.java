package lotto.domain;

import static lotto.constant.ExceptionMessage.BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER;
import static lotto.constant.ExceptionMessage.INVALID_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.constant.Rank;

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
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public Rank getRank(Lotto target) {
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
        return Rank.of(matchCount, matchBonus);
    }
}
