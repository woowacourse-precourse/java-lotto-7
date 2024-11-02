package lotto.model;

import java.util.List;
import lotto.dto.LottoDTO;
import lotto.utils.Message;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        validateDuplicatesNumber(numbers);
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    Message.DEFAULT_HEADER.getMessage() + Message.INVALID_NUMBERS_SIZE.getMessage());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(
                        Message.DEFAULT_HEADER.getMessage() + Message.INVALID_NUMBERS_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicatesNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(
                    Message.DEFAULT_HEADER.getMessage() + Message.INVALID_DUPLICATES_NUMBER.getMessage());
        }
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public LottoDTO toDto() {
        return new LottoDTO(numbers);
    }

    // TODO: 추가 기능 구현
}
