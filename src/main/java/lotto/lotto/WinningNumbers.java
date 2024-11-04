package lotto.lotto;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;

    private WinningNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static WinningNumbers of(String... rawNumbers) {
        List<Integer> numbers = null;
        try {
            numbers = Arrays.stream(rawNumbers)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 형식이 잘못되었습니다.");
        }

        return new WinningNumbers(numbers);
    }

    public List<MatchingCondition> matchWinningNumbersTo(Lottos lottos, BonusNumber bonusNumber) {
        return lottos.convertLottosToMatchedConditions(numbers, bonusNumber);
    }
}
