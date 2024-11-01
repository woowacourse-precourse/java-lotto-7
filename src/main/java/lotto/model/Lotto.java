package lotto.model;

import static lotto.model.BonusNumber.INVALID_NUMBER_RANGE_ERROR_MESSAGE;
import static lotto.model.constant.Lotto.GENERATE_COUNT;
import static lotto.model.constant.Lotto.MAX_NUMBER;
import static lotto.model.constant.Lotto.MIN_NUMBER;

import java.util.List;
import lotto.util.ExceptionHelper;

public class Lotto {
    private final static String NUMBER_AMOUNT_ERROR_MESSAGE = "로또 번호는 6개여야 합니다.";
    public final static String DUPLICATE_NUMBER_ERROR_MESSAGE = "로또 번호는 중복될 수 없습니다.";

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateAmount(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
        this.numbers =numbers;
    }

    private void validateAmount(final List<Integer> numbers) {
        if (numbers.size() != GENERATE_COUNT) {
            throw new IllegalArgumentException(ExceptionHelper.errorMessage(NUMBER_AMOUNT_ERROR_MESSAGE));
        }
    }

    private void validateDuplicate(final List<Integer> numbers) {
        if (numbers.size() != numbers.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException(ExceptionHelper.errorMessage(DUPLICATE_NUMBER_ERROR_MESSAGE));
        }
    }

    private void validateNumberRange(final List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(ExceptionHelper.errorMessage(INVALID_NUMBER_RANGE_ERROR_MESSAGE));
        }
    }

    public List<Integer> get() {
        return numbers;
    }
}