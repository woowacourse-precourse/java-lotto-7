package lotto;

import static java.util.stream.Collectors.joining;
import static lotto.ErrorMessage.NOT_UNIQUE_LOTTO_NUMBER;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoNumberUnique(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateLottoNumberUnique(final List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();

        if (distinctCount != 6) {
            throw new IllegalArgumentException(NOT_UNIQUE_LOTTO_NUMBER.getMessage());
        }
    }

    public String readNumberAscending(final String delimiter) {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(joining(delimiter));
    }

    public Rank getRank(final WinningNumbers winningNumbers, final int bonusNumber) {
        int winningNumberMatchCount = countMatchedWinningNumber(winningNumbers);
        boolean isBonusNumberMatched = numbers.contains(bonusNumber);
        return RankRule.checkRank(winningNumberMatchCount, isBonusNumberMatched);
    }

    private int countMatchedWinningNumber(final WinningNumbers winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::contains)
                .count();
    }
}
