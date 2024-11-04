package lotto;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LottoResultCalculator {
    private final Map<String, Integer> results = new HashMap<>();

    public LottoResultCalculator() {
        results.put("1등", 0);
        results.put("2등", 0);
        results.put("3등", 0);
        results.put("4등", 0);
        results.put("5등", 0);
    }

    public void calculateResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchCount(winningNumbers);
            updateResults(matchCount, lotto.matchBonus(bonusNumber));
        }
    }

    private void updateResults(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            results.put("1등", results.get("1등") + 1);
        } else if (matchCount == 5 && bonusMatch) {
            results.put("2등", results.get("2등") + 1);
        } else if (matchCount == 5) {
            results.put("3등", results.get("3등") + 1);
        } else if (matchCount == 4) {
            results.put("4등", results.get("4등") + 1);
        } else if (matchCount == 3) {
            results.put("5등", results.get("5등") + 1);
        }
    }

    public Map<String, Integer> getResults() {
        return results;
    }
}
