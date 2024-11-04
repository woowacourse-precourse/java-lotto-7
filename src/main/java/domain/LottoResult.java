package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final LottoGame lottoGame;
    private final Lotto winningLotto;
    private final int bonusNumber;
    private final Map<LottoRank, Integer> results = new HashMap<>();

    public LottoResult(LottoGame lottoGame, Lotto winningLotto, int bonusNumber) {
        this.lottoGame = lottoGame;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        calculateResults();
    }

    private void calculateResults() {
        for (Lotto lotto : lottoGame.getLottos()) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winningLotto.getNumbers());
            updateResults(matchCount, lotto.getNumbers());
        }
    }

    private int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream().filter(winningNumbers::contains).count();
    }

    private void updateResults(int matchCount, List<Integer> userNumbers) {
        LottoRank rank = LottoRank.of(matchCount, userNumbers.contains(bonusNumber));
        results.put(rank, results.getOrDefault(rank, 0) + 1);
    }

    public Map<LottoRank, Integer> getResults() {
        return results;
    }
}
