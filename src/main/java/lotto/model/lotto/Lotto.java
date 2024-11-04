package lotto.model.lotto;

import view.exception.LottoException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String LOTTO_SIZE_ERROR = "로또 번호는 6개여야 합니다.";
    private static final String LOTTO_RANGE_ERROR = "로또 번호는 1 ~ 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_DUPLICATE_ERROR = "로또 번호는 중복되지 않은 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_SIZE) {
            throw new LottoException(LOTTO_SIZE_ERROR);
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < LottoConstants.LOTTO_NUM_MIN || num > LottoConstants.LOTTO_NUM_MAX)) {
            throw new LottoException(LOTTO_RANGE_ERROR);
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        boolean hasDuplicates = numbers.stream()
                .distinct()
                .count() != numbers.size();

        if (hasDuplicates) {
            throw new LottoException(LOTTO_DUPLICATE_ERROR);
        }
    }

    public boolean numberContains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        result.append(numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(LottoConstants.LOTTO_PRINT_DELIMITER)))
                .append("]");
        return result.toString();
    }
}
