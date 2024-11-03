package lotto.domain;

import lotto.dto.MatchResult;
import lotto.enums.Message;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.ERROR_PREFIX.getMessage() + "로또 번호는 6개여야 합니다.");
        }
    }

    private int countMatchingNumber(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::contains)
                .count();
    }

    private boolean containsBonusNumber(BonusNumber bonusNumber) {
        return numbers.stream().anyMatch(bonusNumber::isEqualTo);
    }

    public MatchResult compareWithWinningNumbers(WinningNumber winningNumber, BonusNumber bonusNumber) {
        int matchCount = countMatchingNumber(winningNumber);
        boolean containsBonusNumber = containsBonusNumber(bonusNumber);
        return new MatchResult(matchCount, containsBonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
