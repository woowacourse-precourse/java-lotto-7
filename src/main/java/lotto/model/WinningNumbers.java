package lotto.model;

import static lotto.common.exception.ErrorMessage.WINNING_NUMBERS_COUNT_ERROR;
import static lotto.common.exception.ErrorMessage.WINNING_NUMBERS_DUPLICATION_ERROR;

import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private final List<LottoNumber> numbers;

    private WinningNumbers(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static WinningNumbers from(List<LottoNumber> numbers) {
        return new WinningNumbers(numbers);
    }

    public int getMatchCount(Lotto lotto) {
        return (int) lotto.numbers().stream()
                .filter(numbers::contains)
                .count();
    }

    public List<LottoNumber> numbers() {
        return List.copyOf(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        validateNumberCount(numbers);
        validateNoDuplication(numbers);
    }

    private void validateNumberCount(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBERS_COUNT_ERROR.message());
        }
    }

    private void validateNoDuplication(List<LottoNumber> numbers) {
        int distinctCount = Set.copyOf(numbers).size();

        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATION_ERROR.message());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumbers that = (WinningNumbers) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }
}
