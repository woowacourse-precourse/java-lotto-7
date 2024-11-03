package lotto.model;

import static lotto.constant.Constants.ERROR_PREFIX;
import static lotto.constant.Constants.LOTTO_NUMBER_LENGTH;
import static lotto.constant.Constants.LOTTO_NUMBER_RANGE_END;
import static lotto.constant.Constants.LOTTO_NUMBER_RANGE_START;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 로또 번호는 6개여야 합니다.");
        }

        for (int number : numbers) {
            if (number < LOTTO_NUMBER_RANGE_START || number > LOTTO_NUMBER_RANGE_END) {
                throw new IllegalArgumentException(ERROR_PREFIX + " 로또 번호는 1부터 45 사이여야 합니다.");
            }
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 로또 번호에 중복이 없어야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
