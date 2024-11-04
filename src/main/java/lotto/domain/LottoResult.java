package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;
import lotto.enums.LottoValue;

public class LottoResult {

    private final Map<Rank, Integer> result;
    private final int lottoCount;

    public LottoResult(Map<Rank, Integer> result, int lottoCount) {
        this.result = result;
        this.lottoCount = lottoCount;
    }

    public int getMatchesCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public int calculateTotalPrize() {
        return result.entrySet().stream()
                .filter(this::isExist)
                .mapToInt(this::calculateRank)
                .sum();
    }

    private int calculateRank(Entry<Rank, Integer> result) {
        Rank rank = result.getKey();
        int winningCount = result.getValue();
        return rank.getPrize() * winningCount;
    }

    private boolean isExist(Map.Entry<Rank, Integer> result) {
        return result.getValue() > 0;
    }

    public int getPurchasePrice() {
        return lottoCount * LottoValue.LOTTO_PRICE.getValue();
    }
}
