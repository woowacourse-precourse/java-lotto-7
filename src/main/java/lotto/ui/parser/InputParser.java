package lotto.ui.parser;

import lotto.ui.exception.InputException;
import lotto.ui.exception.InputExceptionMessage;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static final String DELIMITER = ",";

    public int paymentAmount(final String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new InputException(InputExceptionMessage.INVALID_NUMBER_FORMAT);
        }
    }

    public List<Integer> inputToWinningNumbers(final String inputWinningNumbers) {
        try {
            return Arrays.stream(inputWinningNumbers.split(DELIMITER)).mapToInt(Integer::parseInt).boxed().toList();
        } catch (NumberFormatException e) {
            throw new InputException(InputExceptionMessage.INVALID_NUMBER_FORMAT);
        }
    }
}
