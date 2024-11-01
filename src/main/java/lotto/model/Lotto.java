package lotto.model;

import static lotto.common.AppConstant.LOTTO_NUMBER_COUNT;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted(Comparator.naturalOrder()).toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalStateException("[ERROR] 로또 번호는 "+ LOTTO_NUMBER_COUNT + "개여야 합니다.");
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
