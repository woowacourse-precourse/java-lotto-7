package lotto;

import static view.message.ExceptionMessage.LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbersCount(numbers);
        validateLottoNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        List<Integer> otherNumbers = otherLotto.getNumbers();
        return (int) numbers.stream()
                            .filter(otherNumbers::contains)
                            .count();
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
