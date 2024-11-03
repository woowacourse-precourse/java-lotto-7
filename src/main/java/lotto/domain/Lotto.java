package lotto.domain;

import java.util.List;
import lotto.message.LottoMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoMessage.OUT_OF_RANGE_LOTTO_NUMBER_AMOUNT.getMessage());
        }
    }

    public List<Integer> getNumber() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.toString());
    }
}
