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
            if (number >=1 && number <= 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateNoDuplicatesBonus(List<Integer> numbers, int bonus) {
        List<Integer> allNumbers = new ArrayList<>(numbers.size());
        for (Integer number : numbers) {
            if (allNumbers.contains(bonus)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 보너스 번호와 중복되지 않아야 한다.");
            }
            allNumbers.add(number);
        }
    }

}
