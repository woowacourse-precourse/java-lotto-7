package lotto.sevice;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.util.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final LottoGenerator generator;
    private static final int LOTTO_PRICE = 1000;
    private static final int HUNDRED = 100;

    public LottoService() {
        this.generator = new LottoGenerator();
    }

    public List<Lotto> issueLottos(int purchaseCount) {
        List<Lotto> issuedLottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            issuedLottos.add(generator.generate());
        }

        return issuedLottos;
    }

    public LottoResult winningProgress(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> ranks = new HashMap<>();

        for (Lotto lotto : lottos) {
            int correct = (int) lotto.getNumbers().stream()
                    .filter(winningLotto.getWinningNumbers().getNumbers()::contains)
                    .count();
            boolean hasBonusNumber = lotto.getNumbers().contains(winningLotto.getBonusNumber());

            Rank rank = Rank.valueOf(correct, hasBonusNumber);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }

        double profitRate = calculateProfitRate(ranks, lottos.size());
        return new LottoResult(ranks, profitRate);
    }

    private double calculateProfitRate(Map<Rank, Integer> ranks, int purchaseCount) {
        int totalPrize = ranks.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        int totalPurchaseAmount = purchaseCount * LOTTO_PRICE;
        return ((double) totalPrize / totalPurchaseAmount) * HUNDRED;
    }
}
