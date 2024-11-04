package lotto;

import static java.util.stream.Collectors.joining;
import static lotto.ErrorMessage.NOT_UNIQUE_LOTTO_NUMBER;
import static lotto.LottoMachine.LOTTO_NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(NOT_UNIQUE_LOTTO_NUMBER.getMessage());
        }
    }

    public String readNumberAscending(final String delimiter) {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(joining(delimiter));
    }

    public Rank getRank(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        int winningNumberMatchCount = countMatchingWinningNumber(winningNumbers);
        boolean isBonusNumberMatched = isBonusNumberMatched(bonusNumber.get());
        return RankRule.checkRank(winningNumberMatchCount, isBonusNumberMatched);
    }

    private boolean isBonusNumberMatched(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private int countMatchingWinningNumber(final WinningNumbers winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::contains)
                .count();
    }
}
