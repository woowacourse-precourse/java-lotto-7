package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.enums.LottoConfig;
import lotto.enums.LottoError;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers, LottoConfig lottoConfig) {
        validate(numbers, lottoConfig);
        this.numbers = numbers;
    }

    public static Lotto ofNumbersAndConfig(List<Integer> numbers, LottoConfig lottoConfig) {
        return new Lotto(numbers, lottoConfig);
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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCountWinningLotto(WinningLotto winningLotto) {
        return numbers.stream()
                .filter(winningLotto::isContains)
                .collect(Collectors.toList())
                .size();
    }

    public boolean isMatchBonusNumber(BonusNumber bonusNumber) {
        return numbers.stream().anyMatch(bonusNumber::isMatch);
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
        return numbers != null ? numbers.hashCode() : 0;
    }
}
