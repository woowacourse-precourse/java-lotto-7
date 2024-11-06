package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static lotto.constants.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}