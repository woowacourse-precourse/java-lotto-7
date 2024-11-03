package lotto.view.validator.winningNumber;

import static lotto.error.ErrorMessage.DUPLICATE_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.PreProcessor;
import lotto.view.validator.InputValidator;

public class WinningNumDuplicateValidator extends InputValidator {

    private WinningNumDuplicateValidator() {}

    public static WinningNumDuplicateValidator initiate() {
        return new WinningNumDuplicateValidator();
    }

    @Override
    public void validate(final String input) {
        List<Integer> numbers = PreProcessor.stringToIntegerList(input);

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }
}
