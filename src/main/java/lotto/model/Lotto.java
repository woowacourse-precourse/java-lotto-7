package lotto.model;

import java.util.List;

public class Lotto {

    private static final String ERROR_LOTTO_NUMBERS_BE_SIX_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBERS_BE_SIX_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
