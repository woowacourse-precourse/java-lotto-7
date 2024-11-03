package lotto.user;

import java.util.List;
import lotto.system.unit.LottoNumber;

public class Lotto { // 사용자 입력 로또 번호 검증 후 객체 생성

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    private static void validateNumberRange(int number) {
        if (number < LottoNumber.LOTTO_NUMBER_LOWER_BOUND || LottoNumber.LOTTO_NUMBER_UPPER_BOUND < number) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d부터 %d사이의 숫자여야 합니다.",
                    LottoNumber.LOTTO_NUMBER_LOWER_BOUND, LottoNumber.LOTTO_NUMBER_UPPER_BOUND));
        }
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
