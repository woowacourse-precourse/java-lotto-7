package lotto.model;

import lotto.enumValue.CommonMessage;
import lotto.validation.WinningNumberValidation;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        WinningNumberValidation.number6(numbers);
        WinningNumberValidation.value1to45(numbers);
        WinningNumberValidation.duplicateChecker(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString() + CommonMessage.NEW_LINE.getMessange();
    }
}
