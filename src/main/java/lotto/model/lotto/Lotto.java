package lotto.model.lotto;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.ExceptionHandler;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionHandler.throwIllegalArgException(ErrorMessage.INVALID_LOTTO_SIZE);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
