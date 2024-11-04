package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbers(numbers);
        validateEachNumber(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalStateException(MessageManager.getError("error.lotto.invalid_numbers"));
        }
        if (numbers.size() != LottoRegulation.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(MessageManager.getFormattedError(
                    "error.lotto.illegal_number_count", LottoRegulation.LOTTO_NUMBERS_COUNT
            ));
        }
    }

    private void validateEachNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number == null) {
                throw new NullPointerException(MessageManager.getError("error.lotto.invalid_number"));
            }
            if (!inRange(number)) {
                throw new IllegalArgumentException(MessageManager.getFormattedError(
                        "error.lotto.out_of_range", LottoRegulation.LOTTO_NUMBER_MIN, LottoRegulation.LOTTO_NUMBER_MAX
                ));
            }
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(MessageManager.getError("error.lotto.number_duplicated"));
        }
    }

    public static boolean inRange(int number) {
        return (number >= LottoRegulation.LOTTO_NUMBER_MIN &&
                number <= LottoRegulation.LOTTO_NUMBER_MAX);
    }
}
