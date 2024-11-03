package lotto.validator;

import java.util.HashSet;
import java.util.List;

public class LottoWinningNumbersValidator {
    private static boolean hasDuplicates(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }
    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.");
            }
            if (winningNumbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
            }
            if (hasDuplicates(winningNumbers)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다.");
            }
        }
    }
}
