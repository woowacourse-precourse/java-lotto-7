package lotto.view.validator.winningNumber;

import static lotto.error.ErrorMessage.INVALID_NUMBER_COUNT;

import java.util.List;
import lotto.view.PreProcessor;
import lotto.view.validator.InputValidator;

public class WinningNumCountValidator extends InputValidator {

    private static final int MAX_NUMBER_COUNT = 6;

    private WinningNumCountValidator() {}

    public static WinningNumCountValidator initiate() {
        return new WinningNumCountValidator();
    }

    @Override
    public void validate(final String input) {
        List<String> numbers = PreProcessor.stringToStringList(input);
        if (numbers.size() != MAX_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_COUNT.getMessage(), MAX_NUMBER_COUNT));
        }
    }
}
