package lotto.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.constant.Amount.SINGLE_DIGIT;
import static lotto.constant.Amount.THOUSAND;
import static lotto.constant.Amount.ZERO;
import static lotto.constant.Condition.ONLY_NUMBERS;
import static lotto.constant.ErrorMessage.INCLUDE_INVALID_DELIMITER;
import static lotto.constant.ErrorMessage.IS_NOT_DIVISIBLE_BY_THOUSAND;
import static lotto.constant.ErrorMessage.IS_NOT_NUMBER;
import static lotto.constant.ErrorMessage.IS_NOT_SINGLE_DIGIT;

public class InputValidator {
    public void validateInputPurchaseAmount(String inputPurchaseAmount) {
        validateMatcherCondition(isNotNumber(inputPurchaseAmount));
        validateIsDivisibleByThousand(inputPurchaseAmount);
    }

    private boolean isNotNumber(String inputNumber) {
        Pattern pattern = MatcherUtil.providePattern(ONLY_NUMBERS.getValue());
        Matcher matcher = MatcherUtil.provideMatcher(pattern, inputNumber);
        return matcher.find();
    }

    private void validateIsDivisibleByThousand(String inputNumber) {
        if (Integer.parseInt(inputNumber) % THOUSAND.getValue() != ZERO.getValue()) {
            throw new IllegalArgumentException(IS_NOT_DIVISIBLE_BY_THOUSAND.getValue());
        }
    }

    private void validateMatcherCondition(boolean isNotNumber) {
        if (isNotNumber) {
            throw new IllegalArgumentException(IS_NOT_NUMBER.getValue());
        }
    }

    private void validateSingleDigit(String bonusNumber) {
        if (bonusNumber.length() > SINGLE_DIGIT.getValue()) {
            throw new IllegalArgumentException(IS_NOT_SINGLE_DIGIT.getValue());
        }
    }

    public void validateBonusNumber(String bonusNumber) {
        validateMatcherCondition(isNotNumber(bonusNumber));
        validateSingleDigit(bonusNumber);
    }

    private void validateDelimiter(String winningNumbers) {
        Pattern pattern = MatcherUtil.providePattern(ONLY_NUMBERS.getValue());
        Matcher matcher = MatcherUtil.provideMatcher(pattern, winningNumbers);
        if (matcher.find()) {
            throw new IllegalArgumentException(INCLUDE_INVALID_DELIMITER.getValue());
        }
    }

    public void validateWinningNumbers(String winningNumbers) {
        validateDelimiter(winningNumbers);
    }
}
