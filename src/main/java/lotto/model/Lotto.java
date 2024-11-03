package lotto.model;

import java.util.List;
import java.util.Set;

import static lotto.constants.ErrorMessage.LOTTO_NUMBER_ONLY_CAN_LENGTH_6;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_ONLY_CAN_RANGE_1_TO_45;
import static lotto.constants.LottoNumbers.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        List<Integer> uniqueNumbers = setUniqueNumbers(numbers);
        validateRange10To45(uniqueNumbers);
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
        }
    }

    private static List<Integer> setUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = Set.copyOf(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
        }

        return uniqueNumbers.stream().toList();
    }

    private static void validateRange10To45(List<Integer> winningNumbers) {
        boolean isLottoNumber = winningNumbers.stream()
                .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
        if (!isLottoNumber) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ONLY_CAN_RANGE_1_TO_45.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
