package lotto.view.validator.bonus;

import lotto.view.validator.RangeValidator;

public class BonusRangeValidator extends RangeValidator {

    private BonusRangeValidator() {
        super("보너스 번호는 1-45 범위 내의 숫자여야 합니다.");
    }

    public static BonusRangeValidator initiate() {
        return new BonusRangeValidator();
    }
}
