package lotto.domain.lotto;

import static lotto.resources.Constants.LOTTO_TOTAL_NUMBERS;
import static lotto.resources.ErrorMessages.DUPLICATE_LOTTO_NUMBER;
import static lotto.resources.ErrorMessages.INVALID_LOTTO_TOTAL_NUMBER;

import java.util.List;
import java.util.Objects;
import lotto.domain.number.Number;
import lotto.domain.number.Numbers;

public class Lotto {
    private final Numbers lottoNumbers;

    Lotto(final Numbers lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = sortAscendingLotto(lottoNumbers);
    }

    private void validate(final Numbers lottoNumbers) {
        validateNumbersSize(lottoNumbers);
        validateDuplicateNumbers(lottoNumbers);
    }

    private void validateNumbersSize(final Numbers lottoNumbers) {
        if (lottoNumbers.getNumbers().size() != LOTTO_TOTAL_NUMBERS) {
            throw new IllegalArgumentException(INVALID_LOTTO_TOTAL_NUMBER.getMessage());
        }
    }

    private void validateDuplicateNumbers(final Numbers lottoNumbers) {
        long sizeWithOutDuplicate = lottoNumbers.getNumbers().stream()
                .distinct()
                .count();

        if (lottoNumbers.getNumbers().size() != sizeWithOutDuplicate) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private Numbers sortAscendingLotto(final Numbers lottoNumbers) {
        List<Integer> sortedNumbers = lottoNumbers.getNumbers().stream()
                .map(Number::getNumber)
                .sorted()
                .toList();

        return Numbers.of(sortedNumbers);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) obj;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        String lottoNumbers = this.lottoNumbers.getNumbers().stream().
                map(Number::getNumber)
                .toList().
                toString();

        return lottoNumbers + "\n";
    }

    public Numbers getLottoNumbers() {
        return lottoNumbers;
    }
}
