package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCnt;
    private final int purchaseAmount;

    public LottoResult(int purchaseAmount) {
        this.rankCnt = new EnumMap<>(LottoRank.class);
        this.purchaseAmount = purchaseAmount;
        initializeResult();
    }

    private void initializeResult() {
        for (LottoRank rank : LottoRank.values()) {
            rankCnt.put(rank, 0);
        }
    }

    private int countMatches(List<Integer> winningNumbers, List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
