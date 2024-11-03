package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.LottoConstants;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.domain.WinningNumbers;

public class LottoService {
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    public void purchaseLottos(int amount) {
        int count = amount / LottoConstants.LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            Lotto lotto = LottoMachine.generateRandomLotto();
            purchasedLottos.add(lotto);
        }
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public Map<LottoRank, Integer> calculateResults(WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> results = new HashMap<>();
        for (Lotto lotto : purchasedLottos) {
            LottoRank rank = calculateRank(lotto, winningNumbers);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
        return results;
    }

    public int calculateTotalPrize(Map<LottoRank, Integer> results) {
        int totalPrize = 0;
        for (Map.Entry<LottoRank, Integer> entry : results.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize;
    }

    public double calculateYield(int purchaseAmount, int totalPrize) {
        double yield = ((double) totalPrize / purchaseAmount) * 100;
        return yield;
    }

    private LottoRank calculateRank(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> winningNums = winningNumbers.getWinningLotto().getNumbers();
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNums::contains)
                .count();
        boolean matchBonus = lotto.getNumbers().contains(winningNumbers.getBonusNumber());
        return LottoRank.valueOf(matchCount, matchBonus);
    }
}
