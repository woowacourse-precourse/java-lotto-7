package lotto.domain.lotto;

import lotto.domain.lotto.vo.LottoNumber;
import lotto.domain.rank.vo.Rank;
import lotto.infrastructure.constant.ExceptionMessage;
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
        int match = 0;
        int bonus = 0;
        for (LottoNumber number : numbers) {
            if (winningLotto.basicNumbers().contains(number.value())) {
                match++;
            }
            if (winningLotto.bonusNumber() == number.value()) {
                bonus++;
            }
        }
        return Rank.of(match, bonus);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new CustomException(ExceptionMessage.INVALID_LOTTO_COUNT(6));
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> removedDuplicate = new HashSet<>(numbers);
        if (removedDuplicate.size() != numbers.size()) {
            throw new CustomException(ExceptionMessage.DUPLICATE);
        }
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
