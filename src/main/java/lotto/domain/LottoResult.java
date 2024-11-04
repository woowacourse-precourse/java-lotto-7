package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private static final int DEFAULT_COUNT = 0;
    private final Map<Rank, Integer> result;

    public LottoResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        this.result = calculateResult(lottoTickets, winningLotto);
    }

    public double calculateProfitRate(PurchaseAmount amount) {
        long totalPrize = calculateTotalPrize();
        return ((double) totalPrize / amount.getAmount()) * 100;
    }

    public int get(Rank rank) {
        return result.getOrDefault(rank, DEFAULT_COUNT);
    }

    private long calculateTotalPrize() {
        return result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private Map<Rank, Integer> calculateResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        Map<Rank, Integer> result = initializeResult();
        lottoTickets.get().forEach(lotto -> updateResult(result, winningLotto, lotto));
        return result;
    }

    private Map<Rank, Integer> initializeResult() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, DEFAULT_COUNT);
        }
        return result;
    }

    private void updateResult(Map<Rank, Integer> result, WinningLotto winningLotto, Lotto lotto) {
        Rank rank = winningLotto.determineRank(lotto);
        result.put(rank, result.get(rank) + 1);
    }
}