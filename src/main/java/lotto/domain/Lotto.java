package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.global.ErrorMessage;

public class Lotto {
    private static final int LOTTO_SIZE_STANDARD = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE_STANDARD) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
        checkForDuplicates(numbers);
    }

    private void checkForDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS_IN_LOTTO.getMessage());
        }
    }

    public Prize match(WinningTicket winningTicket) {
        int matchCount = (int) numbers.stream()
                .filter(winningTicket::contains)
                .count();

        boolean bonusMatch = winningTicket.isBonusNumberMatched(numbers);
        return Prize.valueOf(matchCount, bonusMatch);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
