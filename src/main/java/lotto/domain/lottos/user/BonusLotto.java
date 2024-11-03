package lotto.domain.lottos.user;

import static lotto.domain.InputErrorMessage.LOTTO_RANGE;

import lotto.domain.lottos.Lotto;

public class BonusLotto {
    private final static int MIN = 1;
    private final static int MAX = 45;

    private final int bonus;

    public BonusLotto(int bonus) {
        validateBonusLottoRange(bonus);
        this.bonus = bonus;
    }

    public boolean isContainedMainLotto(Lotto lotto) {
        return lotto.isContainNumber(bonus);
    }

    private void validateBonusLottoRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(LOTTO_RANGE.getMessage());
        }
    }


    @Override
    public String toString() {
        return bonus + "";
    }

}
