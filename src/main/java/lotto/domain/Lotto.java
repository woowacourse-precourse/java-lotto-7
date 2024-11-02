package lotto.domain;

import java.util.List;

import static lotto.exception.ErrorMessages.LOTTO_NUMBER_LENGTH_ERROR;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isSizeSix(numbers.size())) {
            throw new IllegalArgumentException(LOTTO_NUMBER_LENGTH_ERROR);
        }
    }

    private boolean isSizeSix(int size){
        return numbers.size() == 6;
    }

    // TODO: 추가 기능 구현
}
