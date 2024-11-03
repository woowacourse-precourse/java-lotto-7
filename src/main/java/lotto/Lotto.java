package lotto;

import lotto.common.ExceptionMessage;
import lotto.view.LottoOutputView;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        LottoOutputView.printLotto(this);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COUNT_NUMBERS.getMessage());
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_DUPLICATED.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
