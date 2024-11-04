package validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private LottoValidator() {};

    public static void validate(List<Integer> numbers) {
        checkCountOfNumbers(numbers);
        for(Integer number : numbers) {
            checkRangeOfNumbers(number);
        }
        checkSameNumberIsExist(numbers, numbers.size());
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

    private static void checkSameNumberIsExist(List<Integer> numbers, int size) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        if(lottoNumbers.size() != size) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있으면 안됩니다.");
        }
    }
}
