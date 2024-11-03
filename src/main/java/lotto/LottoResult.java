package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public void addWinningResult(final Rank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + WINNING_STATISTICS_PLUS);
    }

    private double calculateReturnRate(final int inputPurchasePrice) {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            totalPrize += (long) entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return (double) totalPrize / inputPurchasePrice * RETURN_RATE_DENOMINATOR;
    }

    public List<Lotto> setLottos(final int inputPurchasePrice) {
        int purchaseQuantity = inputPurchasePrice / PRICE_PER_LOTTO;
        System.out.println("\n" + purchaseQuantity + Message.PURCHASE_QUANTITY.getMessage());

        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            Lotto lotto = new Lotto(Lotto.create());
            System.out.println(lotto.getNumbers());
            purchasedLottos.add(lotto);
        }
        return purchasedLottos;
    }

    private int countMatches(final Lotto purchasedLotto, final Lotto userLotto) {
        return (int) purchasedLotto.getNumbers().stream()
                .filter(userLotto.getNumbers()::contains)
                .count();
    }
}
