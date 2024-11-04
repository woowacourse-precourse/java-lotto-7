package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Rank.MISS;

public class LottoService {
    public static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos = new ArrayList<>();

    public void generateLottos(int purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> calculateResults(WinningLotto winningLotto) {
        Map<Rank, Integer> results = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = getRank(lotto, winningLotto);
            accumulateResult(results, rank);
        }
        return results;
    }

    private Rank getRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = countMatches(lotto, winningLotto.getWinningLotto());
        boolean matchBonus = lotto.getNumbers().contains(winningLotto.getBonusNumber());
        return Rank.valueOf(matchCount, matchBonus);
    }

    private int countMatches(Lotto lotto, Lotto winningLotto) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void accumulateResult(Map<Rank, Integer> results, Rank rank) {
        if (rank == MISS) {
            return;
        }
        results.put(rank, results.getOrDefault(rank, 0) + 1);
    }

    public double calculateProfitRate(WinningLotto winningLotto, int purchaseAmount) {
        Map<Rank, Integer> results = calculateResults(winningLotto);
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
        return ((double) totalPrize / purchaseAmount) * 100;
    }
}