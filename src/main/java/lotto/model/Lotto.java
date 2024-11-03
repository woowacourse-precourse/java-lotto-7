package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final String ERROR_LOTTO_NUMBERS_BE_SIX_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_DUPLICATE_LOTTO_NUMBER_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBERS_BE_SIX_MESSAGE);
        }
        if (new HashSet<>(numbers).size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_LOTTO_NUMBER_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
