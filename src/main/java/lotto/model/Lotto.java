package lotto.model;

import static lotto.model.BonusNumber.INVALID_NUMBER_RANGE_ERROR_MESSAGE;
import static lotto.model.constant.Lotto.GENERATE_COUNT;
import static lotto.model.constant.Lotto.MAX_NUMBER;
import static lotto.model.constant.Lotto.MIN_NUMBER;

import java.util.List;

public class Lotto {
    private final static String NUMBER_AMOUNT_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public final static String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateAmount(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
        this.numbers =numbers;
    }

    private void validateAmount(final List<Integer> numbers) {
        if (numbers.size() != GENERATE_COUNT) {
            throw new IllegalArgumentException(NUMBER_AMOUNT_ERROR_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(final List<Integer> numbers) {
        if (numbers.size() != numbers.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateNumberRange(final List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public List<Integer> get() {
        return numbers;
    }
}

