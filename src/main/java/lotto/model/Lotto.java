package lotto.model;

import java.util.List;
import lotto.util.InputValidator;
import lotto.view.error.InputErrorException;

public class Lotto {

    public static final String NEED_SIX_NUMBERS = "로또 번호는 6개여야 합니다.";

    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers, InputValidator inputValidator) {
        validate(numbers, inputValidator);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers, InputValidator inputValidator) {
        inputValidator.checkIfEmpty(numbers);
        checkLottoNumberCount(numbers);
        inputValidator.checkDuplicate(numbers);
    }

    private void checkLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InputErrorException(NEED_SIX_NUMBERS);
        }
    }
}
