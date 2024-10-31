package lotto;

import static lotto.view.input.InputError.LOTTO_NUMBER_LENGTH_INVALID;

import java.util.List;
import lotto.validation.LottoNumberValidator;
import lotto.view.input.InputError;
import lotto.view.input.InvalidInputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
        this.numbers = numbers;
    }


}
