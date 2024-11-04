package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.common.LottoValidateUtil;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidateUtil.validateLottoNumbersCount(numbers);
        LottoValidateUtil.validateNumberRange(numbers);
    }
}
