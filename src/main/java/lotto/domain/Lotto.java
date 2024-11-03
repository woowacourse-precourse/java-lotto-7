package lotto.domain;

import java.util.List;

import static lotto.util.Utils.sortLottoNumbers;
import static lotto.validation.Validation.*;

public class Lotto {

    private final static Integer LOTTO_START_NUMBER = 1;
    private final static Integer LOTTO_END_NUMBER = 45;
    private final static Integer LOTTO_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortLottoNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        checkLottoSize(numbers, LOTTO_LENGTH);
        checkLottoDuplicate(numbers);
        checkLottoNumberRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
