package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;

    public WinningLotto(String input) {
        this.numbers = Validator.validateAndParseWinningNumbers(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
