package lotto.domain;

import static lotto.util.LottoValidator.validateLottoNumbers;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }
}
