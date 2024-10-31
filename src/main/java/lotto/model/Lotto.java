package lotto.model;

import java.util.List;

public class Lotto {
    private final static String NUMBER_AMOUNT_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private final static String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateAmount(numbers);
        validateDuplicate(numbers);
        this.numbers =numbers;
    }

    private void validateAmount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_AMOUNT_ERROR_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }
}

