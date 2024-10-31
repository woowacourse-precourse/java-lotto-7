package domain.lotto;

import domain.error.LottoErrorMessage;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.LOTTO_NUMBER_COUNT.getErrorMessage());
        }
        int left = 0;
        while (left < 6) {
            for (int right = left+1; right < 6; right++) {
                if (numbers.get(left) == numbers.get(right)) {
                    throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_LOTTO_NUMBER.getErrorMessage());
                }
            }
            left++;
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}
