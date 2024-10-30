package lotto.util.converter;

import lotto.exception.ErrorCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberConverter {

    private static final String DELIMITER = ",";
    private static final String WINNING_NUMBER_PATTERN = "^(?:([1-9]|[1-3][0-9]|4[0-5])(,(?!$)|$))+$";
    private static final String BONUS_NUMBER_PATTERN = "^(?:[1-9]|[1-3][0-9]|4[0-5])$";

    private final String winningNumber;

    public WinningNumberConverter(String inputWinningNumber) {
        validateWinningNumber(inputWinningNumber);
        this.winningNumber = inputWinningNumber;
    }

    public List<Integer> convertWinningNumber() {
        return Arrays.stream(winningNumber.split(DELIMITER))
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public int convertBonusNumber(String inputBonusNumber) {
        validateBonusNumber(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    private void validateWinningNumber(String inputWinningNumber) {
        if (isWinningNumberFormatInvalid(inputWinningNumber)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    private boolean isWinningNumberFormatInvalid(String inputWinningNumber) {
        return !inputWinningNumber.matches(WINNING_NUMBER_PATTERN);
    }

    private void validateBonusNumber(String inputBonusNumber) {
        if (isBonusNumberFormatInvalid(inputBonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
        if (isDuplicateNumber(inputBonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }
    }

    private boolean isBonusNumberFormatInvalid(String inputBonusNumber) {
        return !inputBonusNumber.matches(BONUS_NUMBER_PATTERN);
    }

    private boolean isDuplicateNumber(String inputBonusNumber) {
        return winningNumber.contains(inputBonusNumber);
    }
}
