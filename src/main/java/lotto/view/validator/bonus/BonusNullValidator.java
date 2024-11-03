package lotto.view.validator.bonus;

import lotto.view.validator.NullValidator;

public class BonusNullValidator extends NullValidator {

    private BonusNullValidator() {
        super("보너스 번호는 빈 문자열일 수 없습니다.");
    }

    public static BonusNullValidator initiate() {
        return new BonusNullValidator();
    }
}
