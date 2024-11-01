package lotto.domain;

import java.util.List;
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

        numbers.stream().forEach(number -> {
            validateMoreThanLottoNumberMin(number, lottoConfig);
            validateLessThanLottoNumberMax(number, lottoConfig);
        });
    }

    private void validateDuplicationNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(LottoError.LOTTO_WINNING_NUMBERS_DUPLICATION.getMessage());
        }
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
            throw new IllegalArgumentException();
        }
    }

    public boolean isContains(int number) {
        return numbers.contains(number);
    }
}
