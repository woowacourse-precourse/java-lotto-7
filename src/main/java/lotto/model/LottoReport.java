package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LottoReport {

    private final List<Lotto> purchasedLottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<LottoPrize, Integer> matchCountMap = new HashMap<>();
    private int totalEarnings = 0;

    private LottoReport(List<Lotto> purchasedLottos, WinnerLotto winnerLotto) {
        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winnerLotto.getNumbers();
        this.bonusNumber = winnerLotto.getBonusNumber();
        initializeMatchCountMap();
        generateReport();
    }

    public static LottoReport of(List<Lotto> purchasedLottos, WinnerLotto winnerLotto) {
        return new LottoReport(purchasedLottos, winnerLotto);
    }

    private void initializeMatchCountMap() {
        for (LottoPrize prize : LottoPrize.values()) {
            matchCountMap.put(prize, 0);
        }
    }

    private void generateReport() {
        purchasedLottos.forEach(lotto -> {
            int matchCount = calculateMatchCount(lotto);

            if (isBonusMatch(matchCount, lotto)) {
                updateMatchCountAndEarnings(LottoPrize.MATCH_COUNT_5_WITH_BONUS);
                return;
            }

            if (matchCount >= LottoPrize.MATCH_COUNT_3.getMatchCount()) {
                updateMatchCountAndEarnings(LottoPrize.valueOf("MATCH_COUNT_" + matchCount));
            }
        });
    }

    private int calculateMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isBonusMatch(int matchCount, Lotto lotto) {
        return matchCount == LottoPrize.MATCH_COUNT_5.getMatchCount() && lotto.getNumbers().contains(bonusNumber);
    }

    private void updateMatchCountAndEarnings(LottoPrize prize) {
        matchCountMap.put(prize, matchCountMap.get(prize) + 1);
        totalEarnings += prize.getPrize();
    }

    public Map<LottoPrize, Integer> getMatchCountMap() {
        return matchCountMap;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }
}
