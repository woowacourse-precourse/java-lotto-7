package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int REQUIRED_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final String ERROR_MESSAGE_INVALID_COUNT = "[ERROR] 로또 번호는 " + REQUIRED_NUMBER_COUNT + "개여야 합니다.";
    private static final String ERROR_MESSAGE_DUPLICATE_NUMBERS = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    private static final String ERROR_MESSAGE_OUT_OF_RANGE = "[ERROR] 로또 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_COUNT);
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_NUMBERS);
        }
        if (numbers.stream().anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE);
        }
    }

    // TODO: 추가 기능 구현
    public LottoDTO toDTO() {
        return new LottoDTO(numbers);
    }
}
