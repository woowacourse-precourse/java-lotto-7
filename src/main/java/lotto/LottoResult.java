package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private static final int PRICE_PER_LOTTO = 1000;
    private static final int RETURN_RATE_DENOMINATOR = 100;
    private static final int WINNING_STATISTICS_PLUS = 1;
    private static final int INITIALIZE_RANK_COUNT = 0;

    private final InputView inputView;
    private final OutputView outputView;
    private final Map<Rank, Integer> rankCounts;

    public LottoResult(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.rankCounts = new HashMap<>();
        initializeRankCounts();
    }

    private void initializeRankCounts() {
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, INITIALIZE_RANK_COUNT);
        }
    }
}
