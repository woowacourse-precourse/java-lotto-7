package lotto.lotto;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;

    private WinningNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static WinningNumbers of(String... rawNumbers) {
        List<Integer> numbers = Arrays.stream(rawNumbers)
                .map(Integer::parseInt)
                .toList();

        return new WinningNumbers(numbers);
    }

    public List<MatchingCondition> matchWinningNumbersTo(Lottos lottos, BonusNumber bonusNumber) {
        return lottos.convertLottosToMatchedConditions(numbers, bonusNumber);
    }
}
