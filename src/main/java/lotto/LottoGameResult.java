package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.Rank;

public class LottoGameResult {
    private final Map<Rank, Integer> lottoGameResult;

    public LottoGameResult() {
        this.lottoGameResult = new HashMap<>();
        initResult();
    }

    private void initResult() {
        Arrays.stream(Rank.values()).forEach(rank -> lottoGameResult.put(rank, 0));
    }

    public void updateResult(Rank rank) {
        lottoGameResult.put(rank, lottoGameResult.get(rank) + 1);
    }

    public double calculateEarningRate(int money) {
        double earningRate = (double) totalPrize() / money * 100;
        return Math.round(earningRate * 100) / 100.0;
    }

    private long totalPrize() {
        return lottoGameResult.entrySet()
                .stream()
                .mapToLong(result -> result.getKey().getPrize() * result.getValue())
                .sum();
    }
}
