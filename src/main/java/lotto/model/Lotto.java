package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberSizeIn(numbers);
    }

    private void validateLottoNumberSizeIn(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_IS_NOT_FIT_SIZE.getMsg());
        }
    }

    public List<Integer> lottoNums() {
        return Collections.unmodifiableList(numbers);
    }
}
