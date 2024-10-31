package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.InputLottoNumbersValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        InputLottoNumbersValidator.validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    // TODO: 추가 기능 구현
}
