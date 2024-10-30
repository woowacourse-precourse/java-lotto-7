package lotto.util.converter;

import lotto.exception.ErrorCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberConverter {

    private static final String DELIMITER = ",";
    private static final String WINNING_NUMBER_PATTERN = "^(?:([1-9]|[1-3][0-9]|4[0-5])(,(?!$)|$))+$";

    private final String winningNumber;

    public WinningNumberConverter(String inputWinningNumber) {
        validate(inputWinningNumber);
        this.winningNumber = inputWinningNumber;
    }

    public List<Integer> convert() {
        return Arrays.stream(this.winningNumber.split(DELIMITER))
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    private void validate(String inputWinningNumber) {
        if (isWinningNumberFormatInvalid(inputWinningNumber)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    private boolean isWinningNumberFormatInvalid(String inputWinningNumber) {
        return !inputWinningNumber.matches(WINNING_NUMBER_PATTERN);
    }
}
