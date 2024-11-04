package lotto.domain;

import java.util.List;
import lotto.util.ErrorMessage;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusBall bonusBall;

    public WinningLotto(Lotto lotto, BonusBall bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;
        validateBonusNumberDuplication();
    }

    public List<Integer> numbers() {
        return lotto.numbers();
    }

    public int bonusNumber() {
        return bonusBall.num();
    }

    private void validateBonusNumberDuplication() {
        if (lotto.contains(bonusBall.num())) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_BONUS_NUM_DUPLICATION.getMsg());
        }
    }
}
