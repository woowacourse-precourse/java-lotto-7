package lotto.domain;

import java.util.List;
import lotto.Validator.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumber(numbers);
        this.numbers = numbers;
    }

}
