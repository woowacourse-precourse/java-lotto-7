package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    private LottoValidator() {
    }

    public static final int LOTTO_NUMBER_COUNT = 6;

    public static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.");
        }
    }
}
