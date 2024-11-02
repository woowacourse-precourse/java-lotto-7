package lotto.domain;

import java.util.List;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(int number : numbers) {
            if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
