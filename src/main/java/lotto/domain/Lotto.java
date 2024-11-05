package lotto.domain;

import java.util.List;
import lotto.validation.LottoNumbersValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumbersValidator.validateLottoNumbers(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
