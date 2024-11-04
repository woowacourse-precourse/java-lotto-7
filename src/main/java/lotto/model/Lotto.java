package lotto.model;

import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateSize(numbers);
        LottoValidator.validateNoDuplicates(numbers);
        LottoValidator.validateRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

}
