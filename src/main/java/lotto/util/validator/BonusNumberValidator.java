package lotto.util.validator;

public class BonusNumberValidator {
    public static int validate(String bonusNumber) {
        NumericValidator.validate(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
