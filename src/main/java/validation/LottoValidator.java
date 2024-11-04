package validation;

import java.util.List;

public class LottoValidator {

    public static void validate(List<Integer> numbers) {
        checkCountOfNumbers(numbers);
        for(Integer number : numbers) {
            checkRangeOfNumbers(number);
        }
    }

    private static void checkCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void checkRangeOfNumbers(int number) {
        if(number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 에서 45 사이의 값 이어야 합니다.");
    }
}
