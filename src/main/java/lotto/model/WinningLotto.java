package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<String, Integer> calculateResult(List<Lotto> lottos) {
        Map <String, Integer> lottoResult = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto);
            boolean containsBonusNumber = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) {
                lottoResult.put("1등", lottoResult.getOrDefault("1등", 0) + 1);
                continue;
            }
            if (matchCount == 5 && containsBonusNumber) {
                lottoResult.put("2등", lottoResult.getOrDefault("2등", 0) + 1);
                continue;
            }
            if (matchCount == 5) {
                lottoResult.put("3등", lottoResult.getOrDefault("3등", 0) + 1);
                continue;
            }
            if (matchCount == 4) {
                lottoResult.put("4등", lottoResult.getOrDefault("4등", 0) + 1);
                continue;
            }
            if (matchCount == 3) {
                lottoResult.put("5등", lottoResult.getOrDefault("5등", 0) + 1);
            }
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
