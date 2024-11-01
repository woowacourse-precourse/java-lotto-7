package lotto.domain.lotto;

import lotto.domain.lotto.vo.LottoNumber;
import lotto.domain.rank.vo.Rank;
import lotto.infrastructure.constant.ExceptionMessage;
import lotto.infrastructure.constant.LottoLimit;
import lotto.infrastructure.exception.CustomException;

import java.util.HashSet;
import java.util.List;

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
        if (numbers.size() != LottoLimit.COUNT) {
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
        List<String> numberStrings = numbers.stream()
                .map(LottoNumber::value)
                .map(String::valueOf)
                .toList();
        return "[" + String.join(", ", numberStrings) + "]";
    }
}
