package lotto.validator.entity;

import lotto.enums.ExceptionMessage;
import lotto.validator.Validator;

// 당첨 번호 검증 클래스
public class WinningNumberValidator implements Validator {
    private final String winningNumbers;

    public WinningNumberValidator(String winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    @Override
    public void validate() {
        isNull();
        isValidatedForm();

        for (String winningNumber : winningNumbers.split(",")) {
            isValueInRange(winningNumber);
        }
    }

    private void isValidatedForm() {
        isConsistOfNumberAndComma();
        isStartOrEndWithComma();
        isContainsContinuousComma();
    }

    private void isNull() {
        if (winningNumbers == null) {
            printErrorMessageAndThrowError(ExceptionMessage.WINNING_NUMBER_IS_NULL.getMessage());
        }
    }

    private void isConsistOfNumberAndComma() {
        if (!winningNumbers.matches("[0-9|,]+")) {
            printErrorMessageAndThrowError(ExceptionMessage.WINNING_NUMBER_NOT_VALID_FORMAT.getMessage());
        }
    }

    private void isStartOrEndWithComma() {
        if (winningNumbers.startsWith(",") || winningNumbers.endsWith(",")) {
            printErrorMessageAndThrowError(ExceptionMessage.WINNING_NUMBER_START_OR_END_WITH_COMMA.getMessage());
        }
    }

    private void isContainsContinuousComma() {
        if (winningNumbers.contains(",,")) {
            printErrorMessageAndThrowError(ExceptionMessage.WINNING_NUMBER_HAS_CONTINUOUS_COMMA.getMessage());
        }
    }

    private void isValueInRange(String winningNumber) {
        try {
            int number = Integer.parseInt(winningNumber);

        } catch (Exception e) {
            printErrorMessageAndThrowError(ExceptionMessage.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}