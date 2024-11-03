package lotto;

import common.ErrorMessage;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_WINNER_NUMBER_COUNT.getMessage());
        }
    }

    @Override
    public String toString() {
        return numbers.toString(); // numbers 리스트를 문자열로 변환하여 반환
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
