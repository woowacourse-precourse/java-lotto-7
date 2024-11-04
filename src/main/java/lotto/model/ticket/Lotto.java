package lotto.model.ticket;

import java.util.List;
import lotto.util.Validator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        Validator.checkLottoNumbersCount(numbers);
        Validator.checkLottoNumbersDuplicate(numbers);
        Validator.checkLottoNumbersRange(numbers);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
