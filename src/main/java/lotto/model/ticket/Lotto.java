package lotto.model.ticket;

import java.util.List;
import lotto.util.Validator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.checkLottoNumbersCount(numbers);
        Validator.checkLottoNumbersDuplicate(numbers);
        Validator.checkLottoNumbersRange(numbers);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
