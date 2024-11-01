package lotto.domain;

import java.util.List;
import lotto.enums.LottoConfig;
import lotto.enums.LottoError;

public class WinningLotto {
    private final List<Integer> numbers;
    private final LottoConfig lottoConfig;

    private WinningLotto(List<Integer> numbers, LottoConfig lottoConfig) {
        this.lottoConfig = lottoConfig;
        validate(numbers);
        this.numbers = numbers;
    }

    public static WinningLotto of(List<Integer> numbers, LottoConfig lottoConfig) {
        return new WinningLotto(numbers, lottoConfig);
    }

    private void validate(List<Integer> numbers) {
        validateDuplicationNumbers(numbers);
        validateLottoNumberCount(numbers.size());
        numbers.stream().forEach(number -> {
            validateMoreThanLottoNumberMin(number);
            validateLessThanLottoNumberMax(number);
        });
    }

    private void validateDuplicationNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(LottoError.LOTTO_WINNING_NUMBERS_DUPLICATION.getMessage());
        }
    }

    private void validateMoreThanLottoNumberMin(int number) {
        if (number < lottoConfig.getLottoNumberMin()) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_LESS_THAN_MIN.getMessage());
        }
    }

    private void validateLessThanLottoNumberMax(int number) {
        if (number > lottoConfig.getLottoNumberMax()) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_MORE_THAN_MAX.getMessage());
        }
    }

    private void validateLottoNumberCount(int numberCount) {
        if (numberCount != lottoConfig.getLottoNumberCount()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isContains(int number) {
        return numbers.contains(number);
    }
}
