package lotto.model;

import lotto.util.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final Lotto lotto;
    private final InputValidator validator;

    public WinningNumbers(String input, InputValidator validator) {
        if (validator == null) {
            throw new IllegalStateException("입력 검증기가 초기화되지 않았습니다.");
        }
        this.validator = validator;
        validator.validateWinningNumbers(input);
        this.lotto = new Lotto(parseNumbers(input));
    }

    private List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        if (lotto == null) {
            throw new IllegalStateException("당첨 번호가 초기화되지 않았습니다.");
        }
        return lotto.getNumbers();
    }
}