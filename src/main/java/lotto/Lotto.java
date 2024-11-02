package lotto;

import lotto.message.LottoErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers; // numbers 이외의 필드 추가 불가능, private 변경 불가능

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_NUMBERS_COUNT.getMessage());
        }

        if (numbers.stream().distinct().count() < numbers.size()) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_NUMBERS.getMessage());
        }
    }
    // TODO: 추가 기능 구현
}
