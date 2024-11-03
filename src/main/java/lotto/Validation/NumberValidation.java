package lotto.Validation;

import java.util.ArrayList;
import java.util.List;

public class NumberValidation {

    public static void NumberInputNotNull(String NumberInput) {
        if (NumberInput == null || NumberInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해야 합니다.");
        }
    }

    public static void NumberIsNumeric(String[] ParsedNumberInput) {
        for (String string : ParsedNumberInput) {
            if (!string.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자를 입력해야 합니다.");
            }
        }
    }

    public static void NumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1이상 45이하여야 합니다.");
            }
        }
    }

    public static void NumberNotDuplicate(List<Integer> numbers) {
        List<Integer> allNumbers = new ArrayList<>(numbers.size());
        for (Integer number : numbers) {
            if (allNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
            }
            allNumbers.add(number);
        }
    }
}