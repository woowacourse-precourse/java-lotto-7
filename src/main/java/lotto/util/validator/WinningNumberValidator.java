package lotto.util.validator;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;

public class WinningNumberValidator {

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new InputMismatchException("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalStateException("[ERROR] 중복된 당첨 번호가 있습니다.");
        }

        for (Integer number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 범위 내의 숫자여야 합니다.");
            }
        }
    }

}
