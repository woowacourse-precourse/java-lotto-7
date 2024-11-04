package lotto.utils;

import java.util.List;
import java.util.Map;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.validation.BonusNumberValidator;
import lotto.validation.NumberCountValidator;
import lotto.validation.NumberRangeValidator;
import lotto.validation.StringValidator;
import lotto.validation.UniqueNumberValidator;
import lotto.validation.AmountValidator;
import lotto.validation.Validator;

public class ValidatorFactory {
    public static Validator<Integer> createNumberRangeValidator(int min, int max) {
        return new NumberRangeValidator(min, max, ErrorMessages.NUMBER_OUT_OF_RANGE);
    }

    public static Validator<List<Integer>> createUniqueNumberValidator() {
        return new UniqueNumberValidator(ErrorMessages.LOTTO_NUMBER_DUPLICATE);
    }

    public static Validator<List<Integer>> createNumberCountValidator(int count) {
        return new NumberCountValidator(count, ErrorMessages.LOTTO_NUMBER_COUNT);
    }

    public static Validator<String> createStringValidator() {
        return new StringValidator(ErrorMessages.WINNING_NUMBER_FORMAT);
    }

    public static Validator<WinningNumbers> createBonusNumberValidator(int bonusNumber) {
        return new BonusNumberValidator(bonusNumber, ErrorMessages.BONUS_NUMBER_DUPLICATE);
    }

    private static final Validator<Integer> amountValidator = AmountValidator.getInstance();

    public static Validator<Integer> getAmountValidator() {
        return amountValidator;
    }

    public static void validatePurchaseState(boolean isPurchased) {
        if (isPurchased) {
            throw new IllegalStateException(ErrorMessages.ALREADY_PURCHASED);
        }
    }

    public static void validateWinningNumbersState(WinningNumbers winningNumbers) {
        if (winningNumbers == null || winningNumbers.getNumbers().isEmpty()) {
            throw new IllegalStateException(ErrorMessages.INVALID_WINNING_NUMBER_STATE);
        }
    }

    public static void validateStatisticsState(Map<Rank, Integer> results, int purchaseAmount) {
        if (results == null || results.isEmpty() || purchaseAmount == 0) {
            throw new IllegalStateException(ErrorMessages.INVALID_STATISTICS_STATE);
        }
    }

}
