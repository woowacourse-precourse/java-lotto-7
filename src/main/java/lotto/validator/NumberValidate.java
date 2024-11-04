package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;

public class NumberValidate {

    public static void validateAmount(String input) throws IllegalArgumentException {
        try {
            isEmpty(input);
            isNumeric(input);
            isOverThousand(input);
            isDivisibleByThousand(input);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static void validateDelimitedValue(String[] inputArray) throws IllegalArgumentException {
        try {
            for (String input : inputArray) {
                isEmpty(input);
                isNumeric(input);
            }
        } catch (NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static void validateBonus(Lotto winningNumber, String input) {
        try {
            isEmpty(input);
            isNumeric(input);
            isOutOfRange(input);
            isduplicated(winningNumber, input);
        } catch (NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static void isOverThousand(String input) {
        int amount = Integer.parseInt(input);
        if (amount <= 1000) {
            throw new IllegalArgumentException("[ERROR] 최소금액은 1,000원 입니다.");
        }
    }

    public static void isDivisibleByThousand(String input) {
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000으로 나누어 떨어지는 숫자를 입력해주세요.");
        }
    }

    public static void isEmpty(String input) {
        if (input == null || input.isEmpty() || input.contains(" ")) {
            throw new NullPointerException("[ERROR] 입력값이 null이거나 공백을 포함하고 있습니다.");
        }
    }

    public static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    public static void isSizeSix(List<Integer> input) {
        if (input.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void isOutOfRange(String input) {
        int convert = Integer.parseInt(input);
        if (convert < 1 || convert > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void isOutOfRange(List<Integer> input) {
        for (int number : input) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void isduplicated(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력이 불가합니다.");
        }
    }
    public static void isduplicated(Lotto numbers, String bonus) {
        if (numbers.getNumbers().contains(Integer.parseInt(bonus))) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력이 불가합니다.");
        }
    }
}
