package lotto.model;

import lotto.exception.LottoException;
import lotto.message.ErrorMessage;
import java.util.List;
import static lotto.validator.LottoValidator.validateLottoNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws LottoException {
        validateLottoNumbers(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
