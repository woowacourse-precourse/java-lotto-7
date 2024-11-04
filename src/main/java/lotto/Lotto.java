package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static lotto.constant.Amount.LOTTO_NUMBERS_SIZE;
import static lotto.constant.ErrorMessage.IS_NOT_VALID_NUMBER_SIZE;
import static lotto.constant.ErrorMessage.WINNING_NUMBER_CONFLICT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateWinningNumbersSize(numbers);
        validateDuplicateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateWinningNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(IS_NOT_VALID_NUMBER_SIZE.getValue());
        }
    }

    private void validateDuplicateWinningNumbers(List<Integer> numbers) {
        HashSet<Integer> hashSet = new HashSet<>(numbers);

        if (hashSet.size() != numbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_CONFLICT.getValue());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }


    // TODO: 추가 기능 구현
}
