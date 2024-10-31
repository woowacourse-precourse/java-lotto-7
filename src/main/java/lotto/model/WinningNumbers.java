package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final Lotto lotto;

    public WinningNumbers(String input) {
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
        return lotto.getNumbers();
    }
}