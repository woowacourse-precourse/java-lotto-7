package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void validateInput(String input) {
        final int DIVIDER = 1000;

        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }

        int value = Integer.parseInt(input);
        if (value % DIVIDER != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000으로 나눌 수 없는 값이 입력되었습니다.");
        }
    }

    public static void validateSize(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validateWinnerSize(List<String> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    public static void validateDuplication(List<Integer> lotto) {
        Set<Integer> deleteDuplication = new HashSet<>(lotto);

        if (deleteDuplication.size() != lotto.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public static void validateWinnerDuplication(List<Integer> lotto) {
        Set<Integer> deleteDuplication = new HashSet<>(lotto);

        if (deleteDuplication.size() != lotto.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }

    public static void validateRange(List<Integer> lotto) {
        for (int number : lotto) {
            checkRange(number);
        }
    }

    private static void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void checkWinnerRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateConvertPossibility(String input) {
        if (!input.trim().matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 정수가 아닙니다.");
        }
    }

    public static void validateBonusSize(String bonusNumber) {
        if (bonusNumber.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 하나의 숫자만 입력해야 합니다.");
        }
    }

    public static void checkBonusRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateAllNumber(Set<Integer> lotto) {
        if (lotto.size() != 7) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호에 중복된 숫자가 있습니다.");
        }
    }
}
