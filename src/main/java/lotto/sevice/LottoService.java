package lotto.sevice;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final LottoGenerator generator;
    private static final int LOTTO_PRICE = 1000;
    private static final int FIRST_PRIZE = 2_000_000_000;
    private static final int SECOND_PRIZE = 30_000_000;
    private static final int THIRD_PRIZE = 1_500_000;
    private static final int FOURTH_PRIZE = 50_000;
    private static final int FIFTH_PRIZE = 5_000;

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
        Map<Integer, Integer> ranks = new HashMap<>();
        List<Integer> winningNumbers = winningLotto.getWinningNumbers().getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        double profitRate = 0;

        for (Lotto lotto : lottos) {
            int correct = 0;
            boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);
            List<Integer> lottoNumbers = lotto.getNumbers();

            for (Integer winningNumber : winningNumbers) {
                if (lottoNumbers.contains(winningNumber)) {
                    correct++;
                }
            }

            ranks = calculateRank(ranks ,correct, hasBonusNumber);
        }
        profitRate = calculateProfitRate(ranks, lottos.size());
        return new LottoResult(ranks, profitRate);
    }

    private Map<Integer, Integer> calculateRank(Map<Integer, Integer> ranks, int correct, boolean hasBonusNumber) {
        if (correct == 6) {
            ranks.put(1, ranks.getOrDefault(1, 0) + 1);
        } else if (correct == 5 && hasBonusNumber) {
            ranks.put(2, ranks.getOrDefault(2, 0) + 1);
        } else if (correct == 5) {
            ranks.put(3, ranks.getOrDefault(3, 0) + 1);
        } else if (correct == 4) {
            ranks.put(4, ranks.getOrDefault(4, 0) + 1);
        } else if (correct == 3) {
            ranks.put(5, ranks.getOrDefault(5, 0) + 1);
        } else {
            ranks.put(6, ranks.getOrDefault(6, 0) + 1);
        }
        return ranks;
    }

    public double calculateProfitRate(Map<Integer, Integer> ranks, int purchaseCount) {
        int totalPrize = 0;

        totalPrize += ranks.getOrDefault(1, 0) * FIRST_PRIZE;
        totalPrize += ranks.getOrDefault(2, 0) * SECOND_PRIZE;
        totalPrize += ranks.getOrDefault(3, 0) * THIRD_PRIZE;
        totalPrize += ranks.getOrDefault(4, 0) * FOURTH_PRIZE;
        totalPrize += ranks.getOrDefault(5, 0) * FIFTH_PRIZE;

        int totalPurchaseAmount = purchaseCount * LOTTO_PRICE;

        return ((double) totalPrize / totalPurchaseAmount) * 100;
    }
}
