package lotto.domain;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public enum WinningResult {
    NONE(0, false, 0, "당첨되지 않음"),
    RANK_5TH(3, false, 5_000, "3개 일치"),
    RANK_4TH(4, false, 50_000, "4개 일치"),
    RANK_3TH(5, false, 1_500_000, "5개 일치"),
    RANK_2TH(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    RANK_1TH(6, false, 2_000_000_000, "6개 일치");

    private final int matchCount;
    private final boolean hasBonus;
    private final int winningAmount;
    private final String description;

    WinningResult(int matchCount, boolean hasBonus, int winningAmount, String description) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.winningAmount = winningAmount;
        this.description = description;
    }

    public static WinningResult findByMatchCountAndBonus(int matchCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(result -> result.isMatching(matchCount, hasBonus))
                .findFirst()
                .orElse(NONE);
    }

    public int calculateTotalWinningAmount(int count) {
        return this.winningAmount * count;
    }

    public static List<String> getFormattedResults(Map<WinningResult, Integer> winningResult) {
        return winningResult.entrySet().stream()
                .filter(entry -> entry.getKey() != WinningResult.NONE)
                .map(entry -> entry.getKey().getFormattedResult(entry.getValue()))
                .toList();
    }

    private boolean isMatching(int matchCount, boolean hasBonus) {
        return this.matchCount == matchCount && this.hasBonus == hasBonus;
    }

    private String getFormattedResult(int count) {
        return String.format("%s (%s원) - %d개",
                this.description,
                getFormattedWinningAmount(),
                count
        );
    }

    private String getFormattedWinningAmount() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        return numberFormat.format(this.winningAmount);
    }
}
