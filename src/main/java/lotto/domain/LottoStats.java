package lotto.domain;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoStats {
    private Map<LottoPrize, Integer> prizeCountMap;
    private int totalLottoCount;
    private float profitRate;

    public LottoStats(List<LottoPrize> lottoPrizes, int money) {
        prizeCountMap = new HashMap<>();
        init(lottoPrizes);
        initProfits(money);
    }

    public void init(List<LottoPrize> lottoPrizes) {
        totalLottoCount = lottoPrizes.size();

        for (LottoPrize prize : lottoPrizes) {
            if (Objects.nonNull(prize)) {
                prizeCountMap.put(prize, prizeCountMap.getOrDefault(prize, 0) + 1);
            }
        }
    }

    public void initProfits(int money) {
        int totalPrizeMoney = 0;

        for (Map.Entry<LottoPrize, Integer> entry : prizeCountMap.entrySet()) {
            LottoPrize prize = entry.getKey();
            int count = entry.getValue();
            totalPrizeMoney += count * prize.getPrizeAmount();
        }

        if (totalPrizeMoney > 0) {
            profitRate = totalPrizeMoney / (float) money * 100;
        }
    }

    public Map<LottoPrize, Integer> getPrizeCountMap() {
        return prizeCountMap;
    }

    public float getProfitRate() {
        return profitRate;
    }
}