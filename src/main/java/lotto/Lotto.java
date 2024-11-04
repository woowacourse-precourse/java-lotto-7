package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateWinNumber(numbers);
        this.numbers = numbers;
    }

    public static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
