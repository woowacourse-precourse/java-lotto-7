package lotto.domain.lotto;

import lotto.domain.lotto.vo.LottoNumber;
import lotto.domain.rank.vo.Rank;
import lotto.infrastructure.constant.ExceptionMessage;
import lotto.infrastructure.constant.LottoConfig;
import lotto.infrastructure.exception.CustomException;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .map(LottoNumber::of)
                .toList();
    }

    public Rank getRank(WinningLotto winningLotto) {
        final int match = getMatch(winningLotto.basicNumbers());

        if (match != 5) {
            return Rank.of(match, 0);
        }

        int bonus = getBonus(winningLotto.bonusNumber());
        return Rank.of(match, bonus);
    }

    private int getMatch(List<Integer> targetNumbers) {
        return numbers.stream().map(LottoNumber::value).reduce(0, (total, number) -> {
            if (targetNumbers.contains(number)) {
                return total + 1;
            }
            return total;
        });
    }

    private int getBonus(int bonusNumber) {
        return numbers.stream().map(LottoNumber::value).reduce(0, (total, number) -> {
            if (bonusNumber == number) {
                return total + 1;
            }
            return total;
        });
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.COUNT) {
            throw new CustomException(ExceptionMessage.INVALID_LOTTO_COUNT);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> removedDuplicate = new HashSet<>(numbers);
        if (removedDuplicate.size() != numbers.size()) {
            throw new CustomException(ExceptionMessage.DUPLICATE);
        }
    }

    protected List<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        final String numberString = numbers.stream()
                .map(LottoNumber::value)
                .map(String::valueOf)
                .collect(Collectors.joining(LottoConfig.DELIMITER + " "));
        return "[" + numberString + "]";
    }
}
