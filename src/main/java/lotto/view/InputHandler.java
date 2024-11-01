package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.ErrorMessage;
import lotto.domain.LottoConfig;

public class InputHandler {
    private static final String DELIMITER = ",";

    public int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }

    public void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT.getMessage());
        }
    }

    public List<Integer> parsedNumbers(String input) {
        final List<Integer> parsedNumbers = new ArrayList<>();
        final String[] numbers = input.split(DELIMITER);
        for (final String number : numbers) {
            parsedNumbers.add(validateNumber(number));
        }
        return parsedNumbers;
    }

    public void checkNumberRange(int number) {
        if (number < LottoConfig.MINIMUM.getValue() || number > LottoConfig.MAXIMUM.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
    }
}
