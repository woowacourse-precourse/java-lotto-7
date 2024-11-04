package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int LOTTO_PRICE = 1000;

    private final Map<Rank, Integer> results = new HashMap<>();

    public LottoResult() {
        initialize();
    }

    private void initialize() {
        Arrays.stream(Rank.values())
                .forEach(rank -> results.put(rank, 0));
    }

    public Map<Rank, Integer> calculate(Lottos lottos, WinningLotto winningLotto) {
        lottos.getLottos()
                .forEach(lotto -> addResults(lotto, winningLotto.getLotto(), winningLotto.getBonusNumber()));
        return results;
    }

    public double calculatePrizeRate(int totalLottoCount) {
        long totalPrize = Arrays.stream(Rank.values())
                .mapToLong(rank -> (long) rank.getPrize() * results.get(rank))
                .sum();

        double prizeRate = (totalPrize * 100.0) / (totalLottoCount * LOTTO_PRICE);
        return Math.round(prizeRate * 10.0) / 10.0;
    }

    private void addResults(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = countMatch(lotto, winningLotto);
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
        Rank rank = Rank.valueOf(matchCount, matchBonus);
        results.put(rank, results.get(rank) + 1);
    }

    private int countMatch(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }
}
