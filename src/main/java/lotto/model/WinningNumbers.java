package lotto.model;

import java.util.List;
import lotto.constant.ErrorConstant;

public class WinningNumbers {

    private final List<Integer> numbers;

    private WinningNumbers(final List<Integer> numbers) {
        validateNumbers(numbers);
        validateNumberRange(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public static WinningNumbers create(final List<Integer> numbers) {
        return new WinningNumbers(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException(
                    ErrorConstant.ERROR.getContent() + " 당첨 번호는 " + Lotto.SIZE + "개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Lotto.MINIMUM_THRESHOLD || number > Lotto.MAXIMUM_THRESHOLD) {
                throw new IllegalArgumentException(
                        ErrorConstant.ERROR.getContent() + " 당첨 번호는 " + Lotto.MINIMUM_THRESHOLD + "이상, "
                                + Lotto.MAXIMUM_THRESHOLD
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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public CorrectCount check(final List<Integer> lottoNumbers) {
        int correctCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (this.numbers.contains(lottoNumber)) {
                correctCount++;
            }
            ;
        }
        return CorrectCount.from(correctCount);
    }
}
