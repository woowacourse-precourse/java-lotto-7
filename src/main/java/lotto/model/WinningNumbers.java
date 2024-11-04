package lotto.model;

import lotto.util.InputValidator;
import lotto.util.NumberParser;

import java.util.List;

public class WinningNumbers {
    private final Lotto lotto;

    public WinningNumbers(String input, InputValidator validator) {
        validate(input, validator);
        this.lotto = new Lotto(parseNumbers(input));
    }

    private void validate(String input, InputValidator validator) {
        if (validator == null) {
            throw new IllegalStateException("입력 검증기가 초기화되지 않았습니다.");
        }
        validator.validateWinningNumbers(input);
    }

    private List<Integer> parseNumbers(String input) {
        return NumberParser.parseNumbers(input);
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }
}