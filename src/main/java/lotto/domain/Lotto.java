package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int REQUIRED_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + REQUIRED_NUMBER_COUNT + "개여야 합니다.");
        }
        checkForDuplicates(numbers);
    }

    private void checkForDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
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
