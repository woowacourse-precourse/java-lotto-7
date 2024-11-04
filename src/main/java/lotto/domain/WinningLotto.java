package lotto.domain;

import java.util.List;
import java.util.Objects;
import lotto.enums.LottoConfig;
import lotto.enums.LottoError;

public class WinningLotto {
    private final List<Integer> numbers;

    private WinningLotto(List<Integer> numbers, LottoConfig lottoConfig) {
        validate(numbers, lottoConfig);
        this.numbers = numbers;
    }

    public static WinningLotto ofNumbersAndConfig(List<Integer> numbers, LottoConfig lottoConfig) {
        return new WinningLotto(numbers, lottoConfig);
    }

    private void validate(List<Integer> numbers, LottoConfig lottoConfig) {
        validateDuplicationNumbers(numbers);
        validateLottoNumberCount(numbers.size(), lottoConfig);

        numbers.forEach(number -> validateNumberRange(number, lottoConfig));
    }

    private void validateDuplicationNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBERS_DUPLICATION.getMessage());
        }
    }

    private void validateNumberRange(int number, LottoConfig lottoConfig) {
        validateMoreThanLottoNumberMin(number, lottoConfig);
        validateLessThanLottoNumberMax(number, lottoConfig);
    }

    private void validateMoreThanLottoNumberMin(int number, LottoConfig lottoConfig) {
        if (number < lottoConfig.getLottoNumberMin()) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_LESS_THAN_MIN.getMessage());
        }
    }

    private void validateLessThanLottoNumberMax(int number, LottoConfig lottoConfig) {
        if (number > lottoConfig.getLottoNumberMax()) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_MORE_THAN_MAX.getMessage());
        }
    }

    private void validateLottoNumberCount(int numberCount, LottoConfig lottoConfig) {
        if (numberCount != lottoConfig.getLottoNumberCount()) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBERS_COUNT.getMessage());
        }
    }

    public boolean isContains(int number) {
        return numbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WinningLotto that = (WinningLotto) o;

        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }
}
