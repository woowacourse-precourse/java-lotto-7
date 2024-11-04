package lotto.domain.winning;

import java.util.EnumMap;
import java.util.Map;

public class WinningStatus {

    private final Map<LottoStatus, Integer> prizeCounts;

    public WinningStatus() {
        this.prizeCounts = new EnumMap<>(LottoStatus.class);
        for (LottoStatus status : LottoStatus.values()) {
            prizeCounts.put(status, 0);
        }
    }

    public void addWinning(LottoStatus status) {
        prizeCounts.put(status, prizeCounts.get(status) + 1);
    }

    public int getPrizeCount(LottoStatus status) {
        return prizeCounts.getOrDefault(status, 0);
    }

    public int calculateTotalPrize() {
        return prizeCounts.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
            .sum();
    }
}