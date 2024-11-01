package lotto.constant;

public enum Prize {
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int lottoNumberMatchCount;
    private final boolean shouldMatchBonus;
    private final int earning;
    private final String description;

    Prize(int lottoNumberMatchCount, boolean shouldMatchBonus, int earning, String description) {
        this.lottoNumberMatchCount = lottoNumberMatchCount;
        this.shouldMatchBonus = shouldMatchBonus;
        this.earning = earning;
        this.description = description;
    }

    public static Prize getPrize(int matchedLottoNumberCount, boolean matchedBonus) {
        for (Prize prize : Prize.values()) {
            if (prize.matches(matchedLottoNumberCount, matchedBonus)) {
                return prize;
            }
        }
        return null;
    }

    private boolean matches(int matchedLottoNumberCount, boolean matchedBonus) {
        boolean okWithBonus = true;
        if (this.shouldMatchBonus) {
            okWithBonus = matchedBonus;
        }

        return okWithBonus && this.lottoNumberMatchCount == matchedLottoNumberCount;
    }

    public int getEarning() {
        return this.earning;
    }

    public String getDescription() {
        return this.description;
    }
}
