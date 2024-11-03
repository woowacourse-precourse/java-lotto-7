package lotto.domain;

import lotto.util.LottoValidator;

public class BonusBall {

    private final int bonusNum;

    public BonusBall(int bonusNum) {
        LottoValidator.validateNumberRange(bonusNum);
        this.bonusNum = bonusNum;
    }

    public int num() {
        return bonusNum;
    }
}
