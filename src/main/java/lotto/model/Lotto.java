package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.utils.Utils;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.IVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        if (!Utils.isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}