package lotto.domain;

import lotto.viewHandler.exception.DuplicateNumbers;
import lotto.viewHandler.exception.LottoSizeException;

import java.util.List;

import static lotto.viewHandler.exception.MyExceptionConstant.DUPLICATE_NUMBER;
import static lotto.viewHandler.exception.MyExceptionConstant.NOT_LOTTO_SIZE;

public class Lotto {
    public static final Integer LOTTO_START_NUMBER = 1;
    public static final Integer LOTTO_END_NUMBER = 45;
    public static final Integer LOTTO_SIZE = 6;
    public static final Integer LOTTO_BONUS_COUNT = 1;
    public static final Integer LOTTO_BONUS_RANK_COUNT = 5;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers.stream().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoSizeException(NOT_LOTTO_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long uniqueCount = numbers.stream()
                .distinct()
                .count();

        if (uniqueCount != numbers.size()) {
            throw new DuplicateNumbers(DUPLICATE_NUMBER);
        }
    }
}
