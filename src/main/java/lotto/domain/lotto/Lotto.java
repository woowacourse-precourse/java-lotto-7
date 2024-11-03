package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.LottoValue;
import lotto.domain.LottoErrorTemplate;
import lotto.domain.number.BonusNumber;
import lotto.domain.number.WinningNumbers;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public int countMatchNumbers(WinningNumbers winningNumbers) {
        return (int) this.numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean matchBonusNumber(BonusNumber bonusNumber) {
        return this.numbers.contains(bonusNumber.getNumber());
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoValue.NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    LottoErrorTemplate.INVALID_LOTTO_NUMBER_SIZE.format(LottoValue.NUMBER_SIZE)
            );
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LottoErrorTemplate.DUPLICATE_LOTTO_NUMBER.format());
        }
    }
}