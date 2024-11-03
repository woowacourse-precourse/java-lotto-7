package lotto.domain;

import java.util.List;
import lotto.enums.lotto.LottoMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_LOTTO_SIZE_NOT_EQUALS_6.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> sortedNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }
}
