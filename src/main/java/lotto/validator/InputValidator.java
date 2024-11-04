package lotto.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static void checkInput(String input) {
        if (input == null || input.trim().isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다.");
    }

    public static int checkNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야 합니다.");
        }
    }

    public static void checkUnit(int number) {
        if (number < 1000)
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 이상이어야 합니다." + number);
        if (number % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다." + number);
    }

    public static List<Integer> checkWinningNumbersStr(List<String> winningNumbersStr) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumberStr : winningNumbersStr) {
            checkInput(winningNumberStr);
            winningNumbers.add(checkNumber(winningNumberStr.trim()));
        }
        return winningNumbers;
    }

    public static void checkWinningNumbers(List<Integer> winningNumbers) {
        checkSizeWinningNumbers(winningNumbers);
        checkDuplicateWinningNumbers(winningNumbers);
        checkRangeWinningNumbers(winningNumbers);
    }

    public static void checkSizeWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    public static void checkDuplicateWinningNumbers(List<Integer> numbers) {
        Set<Integer> temp = new HashSet<>(numbers);
        if (numbers.size() != temp.size())
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 숫자로 이루어져야 합니다.");
    }

    public static void checkRangeWinningNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 범위여야 합니다." + number);
        }
    }

    public static void checkRangeBonusNumber(Integer number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위여야 합니다." + number);
    }

    public static void checkWinningNumbersContainsBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다." + bonusNumber);
    }
}
