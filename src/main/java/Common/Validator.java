package Common;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private Validator() {}

    public static List<Integer> validateNumbers(String[] input) {
        if (input.length != 6) throw new IllegalArgumentException("6개의 숫자를 입력해야 합니다.");
        List<Integer> numbers = new ArrayList<>();
        for (String s : input) {
            int number = Integer.parseInt(s);
            validateNumberRange(number);
            numbers.add(number);
        }
        validateDuplicateNumber(numbers);
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
