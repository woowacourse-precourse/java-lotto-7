package lotto.utils;

import java.util.List;
import lotto.domain.WinningNumbers;
import lotto.validation.BonusNumberValidator;
import lotto.validation.NumberCountValidator;
import lotto.validation.NumberRangeValidator;
import lotto.validation.StringValidator;
import lotto.validation.UniqueNumberValidator;
import lotto.validation.AmountValidator;
import lotto.validation.Validator;

public class ValidatorFactory {
    public static Validator<Integer> createNumberRangeValidator(int min, int max, String errorMessage) {
        return new NumberRangeValidator(min, max, errorMessage);
    }

    public static Validator<List<Integer>> createUniqueNumberValidator(String errorMessage) {
        return new UniqueNumberValidator(errorMessage);
    }

    public static Validator<List<Integer>> createNumberCountValidator(int count, String errorMessage) {
        return new NumberCountValidator(count, errorMessage);
    }

    public static Validator<String> createStringValidator(String errorMessage) {
        return new StringValidator(errorMessage);
    }

    public static Validator<WinningNumbers> createBonusNumberValidator(int bonusNumber, String errorMessage) {
        return new BonusNumberValidator(bonusNumber, errorMessage);
    }

    private static final Validator<Integer> amountValidator = AmountValidator.getInstance();

    public static Validator<Integer> getAmountValidator() {
        return amountValidator;
    }

}
