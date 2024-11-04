package lotto;

import lotto.enums.ErrorMessage;
import lotto.enums.LottoRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoRange.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.REQUIRED_LOTTO_NUMBER_COUNT.getText());
        } else if (new HashSet<>(numbers).size() != LottoRange.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getText());
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
