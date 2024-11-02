package lotto.domain;

import java.util.Arrays;
import java.util.List;

import static lotto.message.ErrorMessage.NON_INTEGER_LOTTO;

public class WinningNumbers extends LottoForm {
    private final String SPLIT_DELIMITER = ",";
    private final List<Integer> numbers;

    public WinningNumbers(String input) {
        List<Integer> rawNumbers = convertToIntegers(input);
        this.numbers = validateAndSort(rawNumbers);
    }

    private List<Integer> convertToIntegers(String input) {
        List<String> inputs = Arrays.asList(input.split(SPLIT_DELIMITER));
        try {
            return inputs.stream().map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_LOTTO.getMessage());
        }
    }
}
