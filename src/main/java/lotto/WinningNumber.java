package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
	private final Lotto winningLotto;

    public WinningNumber(String input) {
        this.winningLotto = new Lotto(parseNumbers(input));
    }

    private List<Integer> parseNumbers(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 숫자여야 합니다.");
        }
    }

    public Lotto getLotto() {
        return winningLotto;
    }

}
