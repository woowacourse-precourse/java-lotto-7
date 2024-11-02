package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lotto.constant.Rank;
import lotto.util.Validator;

public class Lotto {
    protected final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public void display() {
        System.out.println(this.numbers);
    }

    public Optional<Rank> calculateRank(WinningLotto winningLotto) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        numbersSet.retainAll(winningLotto.numbers);
        int matchCount = numbersSet.size();

        return convertMatchCountAtRank(matchCount, winningLotto.bonusNumber);
    }

    private Optional<Rank> convertMatchCountAtRank(int matchCount, int bonusNumber) {
        if (matchCount == 5 && numbers.contains(bonusNumber)) {
            return Optional.of(Rank.SECOND);
        }

        if (matchCount >= 3 && matchCount <= 6) {
            return Optional.of(Rank.getRankByMatchCount(matchCount));
        }

        return Optional.empty();
    }
}
