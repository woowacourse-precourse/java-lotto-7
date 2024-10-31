package lotto.model.validator;

import static lotto.exception.InvalidLottoNumberException.DUPLICATE_LOTTO_NUMBERS;
import static lotto.exception.InvalidLottoNumberException.INVALID_LOTTO_NUMBERS;
import static lotto.exception.InvalidLottoNumberException.OUT_OF_RANGE_NUMBER;

import java.util.List;
import lotto.exception.InvalidLottoNumberException;
import lotto.util.LottoConstants;

public class WinningNumbersValidator implements Validator{
    private final List<Integer> lottoNumbers;

    public WinningNumbersValidator(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public void validate() {
        validateNumberCount();
        validateNoDuplicateNumbers();
        validateNumberRange();
    }

    private void validateNumberCount() {
        if (lottoNumbers.size() != LottoConstants.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS);
        }
    }

    private void validateNoDuplicateNumbers() {
        long uniqueNumberCount = getUniqueNumberCount();

        if (uniqueNumberCount != lottoNumbers.size()) {
            throw new InvalidLottoNumberException(DUPLICATE_LOTTO_NUMBERS);
        }
    }

    private void validateNumberRange() {
        boolean outOfRange = lottoNumbers.stream()
                .anyMatch(n -> n < LottoConstants.LOTTO_NUMBER_MIN || n > LottoConstants.LOTTO_NUMBER_MAX);

        if (outOfRange) {
            throw new InvalidLottoNumberException(OUT_OF_RANGE_NUMBER);
        }
    }

    private long getUniqueNumberCount() {
        return lottoNumbers.stream()
                .distinct()
                .count();
    }
}
