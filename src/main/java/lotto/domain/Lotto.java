package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoGameIllegalArgumentException;
import lotto.constant.Rank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoGameIllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
        }
    }

    public void display() {
        System.out.println(this.numbers);
    }

    public Optional<Rank> match(List<Integer> winningLotto, int bonusNumber) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        numbersSet.retainAll(winningLotto);
        int matchCount = numbersSet.size();

        if (matchCount == 3) {
            return Optional.of(Rank.FIFTH);
        }
        if (matchCount == 4) {
            return Optional.of(Rank.FOURTH);
        }
        if (matchCount == 5 && numbers.contains(bonusNumber)) {
            return Optional.of(Rank.SECOND);
        }
        if (matchCount == 5) {
            return Optional.of(Rank.THIRD);
        }
        if (matchCount == 6) {
            return Optional.of(Rank.FIRST);
        }

        return Optional.empty();
    }
}
