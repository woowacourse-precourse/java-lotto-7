package lotto.user;

import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_UPPER_BOUND;
import static lotto.system.utils.constants.LottoErrorMessages.INVALID_NUMBER_COUNT;
import static lotto.system.utils.constants.LottoErrorMessages.INVALID_NUMBER_DUPLICATE;
import static lotto.system.utils.constants.LottoErrorMessages.INVALID_NUMBER_RANGE;

import java.util.List;

public class Lotto { // 사용자 입력 로또 번호 검증 후 객체 생성

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
        validateNumberDuplicate(numbers);
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getMessage(LOTTO_NUMBER_COUNT));
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    private static void validateNumberRange(int number) {
        if (number < LOTTO_NUMBER_LOWER_BOUND || LOTTO_NUMBER_UPPER_BOUND < number) {
            throw new IllegalArgumentException(
                    INVALID_NUMBER_RANGE.getMessage(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND));
        }
    }

    private static void validateNumberDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(INVALID_NUMBER_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
