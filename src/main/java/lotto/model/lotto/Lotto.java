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
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = List.copyOf(numbers.stream().sorted().toList());
    }


    public int getMatchCount(Lotto winnerNumbers) {
        return (int) numbers.stream()
                .filter(winnerNumbers.getNumbers()::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean hasBonus(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto lotto)) return false;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        validateSize(numbers, LOTTO_NUMBERS_COUNT);
        validateNoDuplicates(numbers);
        validateNumberRange(numbers, LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
    }
}
