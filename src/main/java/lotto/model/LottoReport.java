package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoReport {

    private static final int MIN_MATCH_COUNT = 3;
    private static final int MAX_MATCH_COUNT = 6;
    private static final int INITIAL_COUNT = 0;

    private final Map<LottoPrize, Integer> matchCountMap = new HashMap<>();
    private int totalEarnings;

    private LottoReport() {
        initializeMatchCountMap();
    }

    public static LottoReport of(List<Lotto> purchasedLottoList, WinnerLotto winnerLotto) {
        LottoReport lottoReport = new LottoReport();
        purchasedLottoList.forEach(lotto -> lottoReport.addEarnings(lotto, winnerLotto));
        return lottoReport;
    }

    private void initializeMatchCountMap() {
        IntStream.rangeClosed(MIN_MATCH_COUNT, MAX_MATCH_COUNT)
                .forEach(matchCount -> matchCountMap.put(LottoPrize.findByMatchCount(matchCount, false), INITIAL_COUNT));
        matchCountMap.put(LottoPrize.MATCH_COUNT_5_WITH_BONUS, INITIAL_COUNT);
    }

    private void addEarnings(Lotto lotto, WinnerLotto winnerLotto) {
        int matchCount = lotto.getNumbers().stream()
                .filter(winnerLotto.getWinningNumbers()::contains)
                .toList()
                .size();
        boolean hasBonus = winnerLotto.hasBonus(lotto);
        LottoPrize lottoPrize = LottoPrize.findByMatchCount(matchCount, hasBonus);
        if (lottoPrize != null) {
            matchCountMap.put(lottoPrize, matchCountMap.get(lottoPrize) + 1);
            totalEarnings += lottoPrize.getPrize();
        }
    }

    public Map<LottoPrize, Integer> getMatchCountMap() {
        return matchCountMap;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }
}
