package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> result;

    public LottoResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        this.result = calculateResult(lottoTickets, winningLotto);
    }

    public double calculateProfitRate(PurchaseAmount amount) {
        long totalPrize = calculateTotalPrize();
        return ((double) totalPrize / amount.getAmount()) * 100;
    }

    public int get(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    private long calculateTotalPrize() {
        return result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private Map<Rank, Integer> calculateResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        Map<Rank, Integer> result = initializeResult();
        lottoTickets.get().forEach(lotto -> {
            Rank rank = winningLotto.determineRank(lotto);
            result.put(rank, result.get(rank) + 1);
        });
        return result;
    }

    private Map<Rank, Integer> initializeResult() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}