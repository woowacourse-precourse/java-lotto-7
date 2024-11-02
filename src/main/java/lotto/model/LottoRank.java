package lotto.model;

import java.util.Arrays;

public enum LottoRank {

    NO_LUCK("3개 미만 일치 (0원)",
            0L,
            (matchCount, matchBonus) -> matchCount < 3),
    FIFTH("3개 일치 (5,000원)",
            5000L,
            (matchCount, matchBonus) -> matchCount == 3),
    FOURTH("4개 일치 (50,000원)",
            50000L,
            (matchCount, matchBonus) -> matchCount == 4),
    THIRD("5개 일치 (1,500,000원)",
            1500000L,
            (matchCount, matchBonus) -> matchCount == 5 && !matchBonus),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)",
            30000000L,
            (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
    FIRST("6개 일치 (2,000,000,000원)",
            2000000000L,
            (matchCount, matchBonus) -> matchCount == 6);

    private final String description;
    private final long winningAmount;
    private final LottoLankMatcher lottoLankMatcher;

    LottoRank(String description, long winningAmount, LottoLankMatcher lottoLankMatcher) {
        this.description = description;
        this.winningAmount = winningAmount;
        this.lottoLankMatcher = lottoLankMatcher;
    }

    public static LottoRank matchRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> isMatching(matchCount, matchBonus, lottoRank))
                .findFirst()
                .orElse(NO_LUCK);
    }

    private static boolean isMatching(int matchCount, boolean matchBonus, LottoRank lottoRank) {
        return lottoRank.lottoLankMatcher.matchRank(matchCount, matchBonus);
    }

    public String getDescription() {
        return description;
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}
