package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    public static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static List<Lotto> generateLottos(int lottoTickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTickets; i++) {
            lottos.add(LottoGenerator.generate());
        }
        return lottos;
    }

    public static Map<LottoRank, Integer> calculateStatistics(List<Lotto> userLottos, Lotto winningLotto, int bonusNumber) {
        Map<LottoRank, Integer> statistics = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            statistics.put(rank, 0);
        }

        for (Lotto userLotto : userLottos) {
            int matchCount = userLotto.countMatchingNumbers(winningLotto);
            boolean matchBonus = userLotto.containsNumber(bonusNumber);
            LottoRank rank = LottoRank.findRank(matchCount, matchBonus);
            statistics.put(rank, statistics.get(rank) + 1);
        }
        return statistics;
    }

    public static long calculateTotalPrize(Map<LottoRank, Integer> statistics) {
        long totalPrize = 0;

        for (LottoRank rank : statistics.keySet()) {
            long prize = rank.getPrizeAmount();
            int count = statistics.getOrDefault(rank, 0);
            totalPrize += prize * count;
        }

        return totalPrize;
    }

    public static double calculateRateOfReturn(long totalPrize, int purchaseAmount) {
        double rateOfReturn = (double) totalPrize / purchaseAmount * 100;
        return Math.round(rateOfReturn * 10) / 10.0;
    }
}
