package lotto.lotto;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;

    private WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(int bonusNumber, String... rawNumbers) {
        List<Integer> numbers = Arrays.stream(rawNumbers)
                .map(Integer::parseInt)
                .toList();

        return new WinningNumbers(numbers, bonusNumber);
    }

    public List<MatchingCondition> matchWinningNumbersTo(Lottos lottos) {
        return lottos.convertLottosToMatchedConditions(numbers, bonusNumber);
    }
}
