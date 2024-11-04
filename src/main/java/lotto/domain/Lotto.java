package lotto.domain;

import java.util.List;
import lotto.util.ParseUtil;
import lotto.validator.WinningNumbersValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        WinningNumbersValidator.validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    public static Lotto createLotto(String input) {
        WinningNumbersValidator.validateInputWinningNumbers(input);
        return new Lotto(ParseUtil.parseToList(input));
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

}
