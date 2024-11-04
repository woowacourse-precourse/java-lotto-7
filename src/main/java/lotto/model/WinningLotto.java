package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Rank;

public class WinningLotto {
    private final List<Integer> lottoWinningNumbers = new ArrayList<>();
    private final int bonusNumber;

    public WinningLotto(List<Integer> lottoWinningNumbers, int bonusNumber) {
        this.lottoWinningNumbers.addAll(lottoWinningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int matchCount = (int) numbers.stream()
                .filter(lottoWinningNumbers::contains)
                .count();
        boolean matchBonus = numbers.contains(bonusNumber);

        return Rank.valueOf(matchCount, matchBonus);
    }
}
