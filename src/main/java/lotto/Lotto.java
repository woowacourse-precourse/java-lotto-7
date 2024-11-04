package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LottoInfo.NUMBER_COUNT.getInfo()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_COUNT_ERROR.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
