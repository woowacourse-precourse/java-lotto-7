package lotto.model;

import java.util.List;

import static lotto.model.LottoConstants.LOTTO_LAST_NUMBER;
import static lotto.model.LottoConstants.LOTTO_START_NUMBER;
import static lotto.validation.Validation.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersInRange(numbers, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);
        validateListSize(numbers);
        validateDuplicate(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
