package lotto.domain;

import lotto.dto.MatchResult;
import lotto.validation.LottoNumberValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
        this.numbers = numbers;
    }

    public MatchResult compareWithWinningNumbers(WinningNumber winningNumber, BonusNumber bonusNumber) {
        int matchCount = countMatchingNumber(winningNumber);
        boolean containsBonusNumber = containsBonusNumber(bonusNumber);
        return new MatchResult(matchCount, containsBonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private int countMatchingNumber(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::contains)
                .count();
    }

    private boolean containsBonusNumber(BonusNumber bonusNumber) {
        return numbers.stream().anyMatch(bonusNumber::isEqualTo);
    }
}
