package lotto.domain;

import static lotto.constant.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_LENGTH;
import static lotto.constant.ErrorMessage.INVALID_NUMBER_RANGE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Winning {

    private static final String DELIMITER = ",";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int REQUIRED_COUNT = 6;

    private final Lotto lotto;

    public Winning(String input) {
        List<Integer> numbers = parseLottoNumbers(input);
        validateNumbers(numbers);
        this.lotto = new Lotto(numbers);
    }

    public Lotto getLotto() {
        return lotto;
    }

    private List<Integer> parseLottoNumbers(String input) {
        String[] inputSplit = input.split(DELIMITER);
        return Arrays.stream(inputSplit)
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNoDuplicates(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_LENGTH.getMessage());
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
            }
        }
    }
}
