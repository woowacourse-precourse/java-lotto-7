package lotto.validator;

import java.util.ArrayList;
import java.util.List;

public class NumberValidator {

    public static void validateNoDuplicates(List<Integer> numbers) {
        List<Integer> allNumbers = new ArrayList<>(numbers.size());
        for (Integer number : numbers) {
            if (allNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 한다.");
            }
            allNumbers.add(number);
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateNoDuplicatesBonus(List<Integer> winningNumbers, int bonus) {
        for (Integer number : winningNumbers) {
            if (number == bonus) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 보너스 번호와 중복되지 않아야 한다.");
            }
        }
    }

    public static void validateInputBonus(String bonusNumber) {
        if (!bonusNumber.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

    }

    public static void validateBonusNumberRange(int bonus) {
        if (bonus <1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateInput(String[] winningNum) {
        for (String s : winningNum) {
            if (!s.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
            }
        }
    }
}
