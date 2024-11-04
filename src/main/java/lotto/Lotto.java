package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = createSortedNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplication(numbers);
        CommonValidation.validateNumbersRange(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LottoInfo.NUMBER_COUNT.getInfo()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_COUNT_ERROR.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_DUPLICATION_ERROR.getMessage());
        }
    }

    private List<Integer> createSortedNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
