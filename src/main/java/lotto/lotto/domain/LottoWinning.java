package lotto.lotto.domain;

import static lotto.common.exception.ExceptionName.LOTTO_BONUS_NUMBER;
import static lotto.common.exception.ExceptionName.LOTTO_NUMBER_DOMAIN;
import static lotto.common.rule.Rule.LOTTO_MAXIMUM_NUMBER;
import static lotto.common.rule.Rule.LOTTO_MINIMUM_NUMBER;

public class LottoWinning {

    private final Lotto lotto;
    private final int bonusNumber;

    private LottoWinning(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinning of(Lotto lotto, int bonusNumber) {
        validateLottoWinning(lotto, bonusNumber);
        return new LottoWinning(lotto, bonusNumber);
    }

    private static void validateLottoWinning(Lotto lotto, int bonusNumber) {
        if (bonusNumber < LOTTO_MINIMUM_NUMBER || bonusNumber > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DOMAIN);
        }
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_BONUS_NUMBER);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
