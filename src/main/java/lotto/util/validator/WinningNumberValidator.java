package lotto.util.validator;

import lotto.util.ExceptionMessage;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class WinningNumberValidator implements Validator {
    private static final int NUMBER_COUNT = 6;

    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<String> winningNumbers = splitAndValidateInput(input);

        if (winningNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_LENGTH.getMessage());
        }

        validateAndConvertToNumbers(winningNumbers);
    }

    private List<String> splitAndValidateInput(String input) {
        String trimmed = Validator.removeSpace(input);

        if (trimmed.endsWith(",") || trimmed.startsWith(",") || trimmed.contains(",,")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }

        return List.of(trimmed.split(","));
    }

    private List<Integer> validateAndConvertToNumbers(List<String> winningNumbers) {
        try {
            return winningNumbers.stream()
                    .map(Integer::parseInt)  // 숫자 변환
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }
}