package lotto.model;

public enum LottoRule {

    SIX_MATCH(6, "6개 일치 (2,000,000,000원)", 2_000_000_000),
    FIVE_MATCH_BONUS(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000, true),
    FIVE_MATCH(5, "5개 일치 (1,500,000원)", 1_500_000),
    FOUR_MATCH(4, "4개 일치 (50,000원)", 50_000),
    THREE_MATCH(3, "3개 일치 (5,000원)", 5_000);

    private final int matchCount;
    private final String info;
    private final int prize;
    private final boolean bonusMatch;

    LottoRule(int matchCount, String info, int prize){
        this(matchCount, info, prize, false);
    }

    LottoRule(int matchCount, String info, int prize, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.info = info;
        this.prize = prize;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getInfo() {
        return info;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public static LottoRule getWinInfo(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return SIX_MATCH;
        }
        if (matchCount == 5 && bonusMatch) {
            return FIVE_MATCH_BONUS;
        }
        if (matchCount == 5) {
            return FIVE_MATCH;
        }
        if (matchCount == 4) {
            return FOUR_MATCH;
        }
        if (matchCount == 3) {
            return THREE_MATCH;
        }
        return null;
    }
}
