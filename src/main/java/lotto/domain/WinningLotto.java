package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ErrorMessage;

public class WinningLotto {

    public static final int WINNING_LOTTO_SIZE = 7;

    private final Lotto lotto;
    private final BonusBall bonusBall;

    public WinningLotto(Lotto lotto, BonusBall bonusBall) {
        validateBonusNumberDuplication(lotto, bonusBall);
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    public List<Integer> numbers() {
        return lotto.numbers();
    }

    public int bonusNumber() {
        return bonusBall.num();
    }

    private void validateBonusNumberDuplication(Lotto lotto, BonusBall bonus) {
        Set<Integer> duplication = new HashSet<>(lotto.numbers());
        duplication.add(bonus.num());
        if (duplication.size() != WINNING_LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_BONUS_NUM_DUPLICATION.getMsg());
        }
    }
}
