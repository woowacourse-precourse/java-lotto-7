package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.constant.WinningRank;

public class LottoMatchNumberService {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoMatchNumberService(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<WinningRank, Integer> calculateResults(List<Lotto> userLotto) {
        Map<WinningRank, Integer> results = new HashMap<>();

        for (Lotto lotto : userLotto) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();

            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            WinningRank rank = WinningRank.valueOf(matchCount, bonusMatch);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
        return results;
    }
}
