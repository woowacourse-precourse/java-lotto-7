package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    public static final int LOTTO_PRICE = 1000;

    public int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public List<Lotto> generateLottos(int lottoTickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTickets; i++) {
            lottos.add(LottoGenerator.generate());
        }
        return lottos;
    }

    public Map<LottoRank, Integer> calculateStatistics(List<Lotto> userLottos, Lotto winningLotto, int bonusNumber) {
        Map<LottoRank, Integer> statistics = initializeStatisticsMap();

        for (Lotto userLotto : userLottos) {
            LottoRank rank = determineLottoRank(winningLotto, bonusNumber, userLotto);
            statistics.put(rank, statistics.get(rank) + 1);
        }
        return statistics;
    }

    private LottoRank determineLottoRank(Lotto winningLotto, int bonusNumber, Lotto userLotto) {
        int matchCount = userLotto.countMatchingNumbers(winningLotto);
        boolean matchBonus = userLotto.containsNumber(bonusNumber);
        return LottoRank.findRank(matchCount, matchBonus);
    }

    private Map<LottoRank, Integer> initializeStatisticsMap() {
        Map<LottoRank, Integer> statistics = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            statistics.put(rank, 0);
        }
        return statistics;
    }

    public long calculateTotalPrize(Map<LottoRank, Integer> statistics) {
        long totalPrize = 0;

        for (LottoRank rank : statistics.keySet()) {
            int prize = rank.getPrize();
            int count = statistics.getOrDefault(rank, 0);
            totalPrize += (long) prize * count;
        }

        return totalPrize;
    }

    public double calculateRateOfReturn(long totalPrize, int purchaseAmount) {
        double rateOfReturn = (double) totalPrize / purchaseAmount * 100;
        return Math.round(rateOfReturn * 10) / 10.0;
    }
}
