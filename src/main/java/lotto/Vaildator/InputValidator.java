package lotto.Vaildator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void valid(List<Integer> numbers) {
        validSize(numbers);
        validRange(numbers);
    }

    public static void validInput(String input) {
        validEmpty(input);
        validNum(input);
        validDuplicate(input);
    }

    private static void validSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validBonus(String bonus) {
        validEmpty(bonus);
        if (!isNumeric(bonus)) {
            throw new IllegalArgumentException("[ERROR] 숫자 외 문자 혹은 공백은 포함할 수 없습니다.");
        }
        int bonusNumber = Integer.parseInt(bonus.trim());
        if (!isRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45여야 합니다.");
        }
    }

    public static void bonusDuple(int bonusNumber, List<Integer> winningNumbers) {
        for (int num : winningNumbers) {
            if (num == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 당첨번호와 숫자가 중복됩니다.");
            }
        }
    }

    private static List<String> parseInput(String input) {
        String[] splitNumbers = input.split(",");
        List<String> numbers = new ArrayList<>();
        for (String number : splitNumbers) {
            numbers.add(number.trim());
        }
        return numbers;
    }

    private static void validEmpty(String input) {
        for (String number : parseInput(input)) {
            if (isEmpty(number)) {
                throw new IllegalArgumentException("[ERROR] 빈 값은 포함할 수 없습니다.");
            }
        }
    }

    private static void validNum(String input) {
        for (String number : parseInput(input)) {
            String trimmedNumber = number.trim();
            if (!trimmedNumber.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 숫자 외 문자 혹은 공백은 포함할 수 없습니다.");
            }
        }
    }

    private static void validDuplicate(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : parseInput(input)) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if (uniqueNumber.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 포함되어 있습니다.");
        }
    }

    private static void validRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (!isRange(num)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45여야 합니다.");
            }
        }
    }

    private static boolean isRange(int num) {
        return num >= 1 && num <= 45;
    }

    private static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }

    private static boolean isEmpty(String input) {
        String trimmedInput = input.trim();
        return trimmedInput.isEmpty();
    }

}