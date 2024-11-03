package lotto.custom.model;

import static lotto.custom.constants.NumberConstants.LOTTO_NUMBERS_PER_TICKET;
import static lotto.custom.constants.NumberConstants.LOTTO_NUMBER_RANGE_END;
import static lotto.custom.constants.NumberConstants.LOTTO_NUMBER_RANGE_START;
import static lotto.custom.validator.CustomErrorMessages.LOTTO_NUMBERS_MUST_BE_UNIQUE;
import static lotto.custom.validator.CustomErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        } // 기존 코드는 숫자와 예외메시지 상수처리를 하지 않았습니다.
        validateUniqueNumbers(numbers);
        validateNumberRange(numbers);
    }

    /*
    아래 두 코드들은 common.Exceptions 와 validator.InputValidator 의 코드와 겹치나,
    lotto의 원형을 최대한 유지하기 위해 이와 같이 작성되었습니다.
     */

    private void validateUniqueNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_PER_TICKET) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_MUST_BE_UNIQUE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_NUMBER_RANGE_START || number > LOTTO_NUMBER_RANGE_END) {
                throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}