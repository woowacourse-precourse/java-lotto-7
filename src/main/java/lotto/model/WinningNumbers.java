package lotto.model;

import static lotto.model.Lotto.MAXIMUM_THRESHOLD;
import static lotto.model.Lotto.MINIMUM_THRESHOLD;

import java.util.List;
import lotto.constant.ErrorConstant;

public class WinningNumbers {

    private final List<Integer> numbers;

    public WinningNumbers(final List<Integer> numbers) {
        validateNumbers(numbers);
        validateNumberRange(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException(
                    ErrorConstant.ERROR.getContent() + " 당첨 번호는 " + Lotto.SIZE + "개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MINIMUM_THRESHOLD || number > MAXIMUM_THRESHOLD) {
                throw new IllegalArgumentException(
                        ErrorConstant.ERROR.getContent() + " 당첨 번호는 " + MINIMUM_THRESHOLD + "이상, " + MAXIMUM_THRESHOLD
                                + "이하만 가능합니다.");
            }
        }
    }

    private void validateDuplicatedNumber(final List<Integer> numbers) {
        final long notDuplicatedCount = numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != notDuplicatedCount) {
            throw new IllegalArgumentException(
                    ErrorConstant.ERROR.getContent() + " 당첨 번호는 서로 중복되어선 안됩니다."
            );
        }
    }
}
