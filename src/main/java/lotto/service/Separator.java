package lotto.service;

import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private static final String TOKENIZER = ",";
    private final InputException inputException = new InputException();

    public List<Integer> separate(String input) {
        String[] numbers = input.split(TOKENIZER);
        List<Integer> trimmedNumbers = new ArrayList<>();

        for (String number : numbers) {
            trimmedNumbers.add(trimInput(number));
        }

        inputException.validateSizeOfWinningNumbers(trimmedNumbers);

        return trimmedNumbers;
    }

    public int trimInput(String input) {
        String trimmedNumber = input.trim();

        inputException.validateNumericInput(trimmedNumber);
        int trimmedNumberValue = Integer.parseInt(trimmedNumber);
        inputException.validateValueInRange(trimmedNumberValue);

        return trimmedNumberValue;
    }
}
