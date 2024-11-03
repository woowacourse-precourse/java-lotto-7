package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static final int ZERO = 0;
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static void validateMultiplier(int dividend, int divisor) {
        if (dividend < divisor || dividend % divisor != ZERO) {
            System.out.printf("[ERROR] 입력 값은 %d단위여야 합니다.", divisor);
            throw new IllegalArgumentException();
        }
    }

    public static void validateEmptyInput(String input) {
        if (input.isBlank()) {
            System.out.println("[ERROR] 입력 값이 공백 혹은 빈 문자열입니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 값이 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateNegativeNumber(int number) {
        if (number < 0) {
            System.out.println("[ERROR] 입력 값이 음수이면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicatedNumbers(List<Integer> selectedNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : selectedNumbers) {
            validateDuplicatedNumber(uniqueNumbers, number);
        }
    }

    private static void validateDuplicatedNumber(Set<Integer> uniqueNumbers, Integer number) {
        if (!uniqueNumbers.add(number)) {
            System.out.println("[ERROR] 중복되는 번호가 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumberCount(List<Integer> selectedNumbers) {
        if (selectedNumbers.size() != LOTTO_NUMBER_SIZE) {
            System.out.println("[ERROR] 당첨 번호의 개수는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateNegativeNumbers(List<Integer> selectedNumbers) {
        for (Integer number : selectedNumbers) {
            validateNegativeNumber(number);
        }
    }
}
