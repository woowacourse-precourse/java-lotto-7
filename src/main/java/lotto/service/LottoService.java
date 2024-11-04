package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.PrizeRank;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public List<Lotto> purchaseLottos(int amount) {
        validatePurchaseAmount(amount);
        int count = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private void validatePurchaseAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public Map<PrizeRank, Integer> calculateStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<PrizeRank, Integer> statistics = initializeStatistics();

        for (Lotto lotto : lottos) {
            int matchCount = winningLotto.matchNumbers(lotto);
            boolean hasBonus = winningLotto.hasBonusNumber(lotto);
            PrizeRank rank = PrizeRank.findByMatch(matchCount, hasBonus);
            statistics.put(rank, statistics.get(rank) + 1);
        }
        return statistics;
    }

    private Map<PrizeRank, Integer> initializeStatistics() {
        Map<PrizeRank, Integer> statistics = new EnumMap<>(PrizeRank.class);
        for (PrizeRank rank : PrizeRank.values()) {
            statistics.put(rank, 0);
        }
        return statistics;
    }

    public double calculateProfitRate(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<PrizeRank, Integer> statistics = calculateStatistics(lottos, winningLotto);
        long totalPrize = calculateTotalPrize(statistics);
        int totalCost = lottos.size() * LOTTO_PRICE;

        return (totalPrize * 100.0) / totalCost;
    }

    private long calculateTotalPrize(Map<PrizeRank, Integer> statistics) {
        return statistics.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }
}
