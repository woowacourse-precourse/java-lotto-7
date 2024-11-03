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

    // 여기서는 단순히 문자, 숫자 등에 대한 검증 로직
}
