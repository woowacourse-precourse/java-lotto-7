package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;

public class LottoValidator {

    public static final String NUMBERS_SIZE_ERROR_MESSAGE = "로또 번호는 6개여야 합니다.";
    public static final String NUMBERS_DUPLICATED_ERROR_MESSAGE = "로또 번호는 중복되지 않은 6개의 숫자여야 합니다.";
    public static final String NUMBER_OUT_OF_RANGE_ERROR_MESSAGE = "로또 번호는 최소 1부터 45까지의 숫자여야 합니다.";

    public void validateNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersDuplicate(numbers);

        for (Integer number : numbers) {
            validateNumber(number);
        }
    }

    public void validateNumber(int number) {
        validateNumberRange(number);
    }

    private void validateNumberRange(int number) {
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBERS_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATED_ERROR_MESSAGE);
        }
    }
}
