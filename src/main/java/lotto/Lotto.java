package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateWinNumber(numbers);
        this.numbers = numbers;
    }

    public Rank matchWinNumbers(List<Integer> winNumbers, int bonusNumber) {
        int matchCount = 0;

        for (int number : numbers) {
            if (winNumbers.contains(number)) {
                matchCount++;
            }
        }

        boolean matchBonus = numbers.contains(bonusNumber);

        return Rank.valueOf(matchCount, matchBonus);
    }

    public String toString() {
        return "[" + String.join(", ", numbers.stream()
                .map(String::valueOf)
                .toList()) + "]";
    }

}
