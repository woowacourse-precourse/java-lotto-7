package lotto;

import static lotto.model.LottoStore.LOTTO_NUMBER_MAXIMUM;
import static lotto.model.LottoStore.LOTTO_NUMBER_MINIMUM;

import java.util.List;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.isEqualListSize(numbers, 6);
        numbers.forEach(number -> {
            Validator.isNumberWithinRange(number, LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM);
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
