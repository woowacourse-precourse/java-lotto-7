package lotto.lotto;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;

    private WinningNumbers(List<Integer> numbers) {
        validateNumOfNumbers(numbers);
        validateNumbersInRange(numbers);
        validateDuplicated(numbers);
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

    private void validateNumOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream().anyMatch(number -> number < 1 || number > 45);

        if (isOutOfRange) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 정수여야 합니다.");
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        int size = (int) numbers.stream()
                .distinct()
                .count();

        if (size != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 중복되면 안 됩니다.");
        }
    }

    public List<MatchingCondition> matchWinningNumbersTo(Lottos lottos, BonusNumber bonusNumber) {
        return lottos.convertLottosToMatchedConditions(numbers, bonusNumber);
    }
}
