package lotto.validator;

public class BonusNumberInputValidator {

    public static void validateBonusNumberInput(String input) {
        CommonInputValidator.validateCommonInput(input);
        NumberInputValidator.validateNumberInput(input);
    }

}
