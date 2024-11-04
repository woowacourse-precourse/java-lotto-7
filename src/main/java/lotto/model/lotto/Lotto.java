package lotto.model.lotto;

import static lotto.util.CommonValidator.validateNoDuplicates;
import static lotto.util.CommonValidator.validateNumberRange;
import static lotto.util.CommonValidator.validateSize;
import static lotto.util.LottoConstants.LOTTO_NUMBERS_COUNT;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MIN;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = List.copyOf(lottoNumbers.stream().sorted().toList());
    }

    public int getMatchCount(Lotto winnerNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winnerNumbers.getLottoNumbers()::contains)
                .count();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean hasBonus(Integer bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto lotto)) return false;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        validateSize(numbers, LOTTO_NUMBERS_COUNT);
        validateNoDuplicates(numbers);
        validateNumberRange(numbers, LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
    }
}
