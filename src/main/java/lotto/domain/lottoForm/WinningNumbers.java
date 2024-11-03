package lotto.domain.lottoForm;

import java.util.Arrays;
import java.util.List;

import static lotto.message.ErrorMessage.BONUS_NUMBER_DUPLICATE;
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

    public void validateDuplicate(int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
