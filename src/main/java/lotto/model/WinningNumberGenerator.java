package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberGenerator {
    public static WinningNumber registerWinningNumber(String winningNumberInput) {
        try {
            List<Integer> winningNumber = Arrays.stream(winningNumberInput.split(",", -1))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new WinningNumber(winningNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자값만 입력해주세요.");
        }
    }
}
