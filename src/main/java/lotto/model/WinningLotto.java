package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> calculateResult(List<Lotto> lottos) {
        Map<Rank, Integer> lottoResult = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto);
            boolean containsBonusNumber = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, containsBonusNumber);

            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
        return lottoResult;
    }

    private int countMatchingNumbers(Lotto lotto) {
        int count = 0;

        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }
}
