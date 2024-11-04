package lotto.utils;

import java.util.List;

public class WinningCalculator {

    private WinningCalculator() {
    }

    public static int countMatchingNumber(List<Integer> lottoNumbers,
            List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public static boolean isBonusNumberMatched(List<Integer> winningNumbers, int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }
}
