package lotto.domain;

import java.util.List;
import lotto.message.LottoMessage;
import lotto.validate.LottoValidate;

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

        if (!LottoValidate.isNotDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(LottoMessage.IS_DUPLICATE_NUMBER.getMessage());
        }
    }

    public int getSize() {
        return numbers.size();
    }

    public List<Integer> getNumber() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.toString());
    }
}
