package lotto.model.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LotteryNumberValidator {
    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateEachNumber(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateEachNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (addedDuplicated(number, uniqueNumbers)) {
                throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해주세요.");
            }
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1 이상 45 이하의 정수를 입력해주세요.");
            }
        }
    }

    private static boolean addedDuplicated(int number, Set<Integer> uniqueNumbers) {
        return !uniqueNumbers.add(number);
    }
}
