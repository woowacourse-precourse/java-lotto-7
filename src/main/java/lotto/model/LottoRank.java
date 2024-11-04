package lotto.model;

import java.util.Arrays;

public enum LottoRank {

    NO_LUCK("3개 미만 일치 (0원)",
            0L,
            (numberMatchCount, bonusNumberMatch) -> numberMatchCount < 3),
    FIFTH("3개 일치 (5,000원)",
            5000L,
            (numberMatchCount, bonusNumberMatch) -> numberMatchCount == 3),
    FOURTH("4개 일치 (50,000원)",
            50000L,
            (numberMatchCount, bonusNumberMatch) -> numberMatchCount == 4),
    THIRD("5개 일치 (1,500,000원)",
            1500000L,
            (numberMatchCount, bonusNumberMatch) -> numberMatchCount == 5 && !bonusNumberMatch),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)",
            30000000L,
            (numberMatchCount, bonusNumberMatch) -> numberMatchCount == 5 && bonusNumberMatch),
    FIRST("6개 일치 (2,000,000,000원)",
            2000000000L,
            (numberMatchCount, bonusNumberMatch) -> numberMatchCount == 6);

    private final String description;
    private final long winningAmount;
    private final LottoLankMatcher lottoLankMatcher;

    LottoRank(String description, long winningAmount, LottoLankMatcher lottoLankMatcher) {
        this.description = description;
        this.winningAmount = winningAmount;
        this.lottoLankMatcher = lottoLankMatcher;
    }

    public static LottoRank matchRank(int numberMatchCount, boolean bonusNumberMatch) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> isMatchingCondition(numberMatchCount, bonusNumberMatch, lottoRank))
                .findFirst()
                .orElse(NO_LUCK);
    }

    private static boolean isMatchingCondition(int numberMatchCount, boolean bonusNumberMatch, LottoRank lottoRank) {
        return lottoRank.lottoLankMatcher.matchRank(numberMatchCount, bonusNumberMatch);
    }

    public String getDescription() {
        return description;
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}
