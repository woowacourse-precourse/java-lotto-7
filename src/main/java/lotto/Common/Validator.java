package lotto.Common;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private Validator() {}

    public static void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }
    public static List<Integer> validateNumbers(List<Integer> numbers) {
        for (int num : numbers) {
            validateNumberRange(num);
        }
        return numbers;
    }

    public static void validateNumberRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자를 입력하면 안됩니다.");
        }
    }
}
