package lotto.util.validator;

import static lotto.util.Constants.LOTTO_MAX_RANGE;
import static lotto.util.Constants.LOTTO_MIN_RANGE;

import lotto.util.ExceptionMessage;
import java.util.List;
import java.util.stream.Collectors;
import static lotto.util.Constants.NUMBER_COUNT;

public class WinningNumberValidator implements Validator {

    @Override
    public List<Integer> validate(String input) throws IllegalArgumentException {
        List<String> winningNumbers = splitAndValidateInput(input);
        if (winningNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_LENGTH.getMessage());
        }
        return validateAndConvertToNumbers(winningNumbers);
    }


    private List<String> splitAndValidateInput(String input) {
        String trimmed = Validator.removeSpace(input);

        if (trimmed.endsWith(",") || trimmed.startsWith(",") || trimmed.contains(",,")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }

        return List.of(trimmed.split(","));
    }

    private List<Integer> validateAndConvertToNumbers(List<String> winningNumbers) {
        return winningNumbers.stream()
                .map(this::parseAndValidateNumber)
                .collect(Collectors.toList());
    }

    private int parseAndValidateNumber(String numberStr) {
        int number;
        try {
            number = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
        validateLottoNumberRange(number);
        return number;
    }

    private void validateLottoNumberRange(int number) {
        if (number < LOTTO_MIN_RANGE || number > LOTTO_MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_LOTTO_RANGE.getMessage());
        }
    }
}
