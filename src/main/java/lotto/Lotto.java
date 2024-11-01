package lotto;

import static lotto.constant.ErrorMessage.NOT_SIX_WINNING_NUMBER;

import java.util.Collections;
import java.util.List;
import lotto.util.DuplicateWinningNumberException;

public class Lotto {
    private static final int WINNING_NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NOT_SIX_WINNING_NUMBER.getMessage());
        }
        if (numbers.size() != numbers.stream().distinct().toList().size()) {
            throw new DuplicateWinningNumberException();
        }
    }


    public String printLottoNumbers() {
        return numbers.toString();
    }
}
