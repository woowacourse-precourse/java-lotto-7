package lotto;

import java.util.Arrays;
import java.util.List;

public class WinningLottoFactory {
    public static WinningLotto create(String numbers, String bonusNumber) {
        List<Integer> winningNumbers = parseNumbers(numbers);
        return new WinningLotto(new Lotto(winningNumbers), Integer.parseInt(bonusNumber));
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
