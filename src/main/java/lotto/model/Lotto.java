package lotto.model;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted(Comparator.naturalOrder()).toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public LottoRank getRankFrom(WinningLotto winningLotto) {
        List<Integer> winningNumberList = winningLotto.getWinningNumberList();
        List<Integer> list = this.numbers.stream().filter(winningNumberList::contains).toList();

        if (list.size() == LottoRank.RANK_2.matchCount) {
            int bonusNumber = winningLotto.getBonusNumber();

            return LottoRank.by(list.size(), numbers.contains(bonusNumber));
        }

        return LottoRank.by(list.size(), false);
    }
}
