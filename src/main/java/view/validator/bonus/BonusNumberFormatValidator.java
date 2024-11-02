package view.validator.bonus;

import view.validator.NumberFormatValidator;

public class BonusNumberFormatValidator extends NumberFormatValidator {

    private BonusNumberFormatValidator() {
        super("보너스 번호는 양수여야 합니다.");
    }

    public static BonusNumberFormatValidator initiate() {
        return new BonusNumberFormatValidator();
    }
}
