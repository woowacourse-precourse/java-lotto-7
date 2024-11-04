package lotto;

import java.util.Arrays;
import java.util.List;

public class WinningLottoFactory {
    public static WinningLotto create(String numbers, String bonusNumber) {
        List<Integer> winningNumbers = parseNumbers(numbers);
        validate(winningNumbers);
        return new WinningLotto(new Lotto(winningNumbers), Integer.parseInt(bonusNumber));
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private static void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개를 입력해야 합니다");
        }
    }
}
