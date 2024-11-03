package lotto.user;

import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_UPPER_BOUND;

import java.util.List;

public class Lotto { // 사용자 입력 로또 번호 검증 후 객체 생성

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
        validateNumberDuplicate(numbers);
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    private static void validateNumberRange(int number) {
        if (number < LOTTO_NUMBER_LOWER_BOUND || LOTTO_NUMBER_UPPER_BOUND < number) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d부터 %d사이의 숫자여야 합니다.",
                    LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND));
        }
    }

    private static void validateNumberDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
