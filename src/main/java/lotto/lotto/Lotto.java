package lotto.lotto;

import java.util.List;
import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        this.numbers = convertFrom(numbers);
    }

    private List<Number> convertFrom(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::new)
                .toList();
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new CustomException(ExceptionMessage.INVALID_LOTTO_SIZE_EXCEPTION);
        }
    }

    // TODO: 추가 기능 구현
}
