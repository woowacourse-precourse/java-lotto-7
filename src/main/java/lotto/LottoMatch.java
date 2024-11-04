package lotto;

public enum LottoMatch {
    FIFTH_PLACE(3, false, 5_000, "3개 일치 (5,000원) - "),
    FOURTH_PLACE(4, false, 50_000, "4개 일치 (50,000원) - "),
    THIRD_PLACE(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND_PLACE(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PLACE(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;
    private final String winningStatistics;

    LottoMatch(int matchCount, boolean matchBonus, int prize, String winningStatistics) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.winningStatistics = winningStatistics;
    }


    public static LottoMatch getLottoMatch(int matchCount, boolean matchBonus) {
        for (LottoMatch lottoMatch : values()) {
            if (lottoMatch.matchCount == matchCount && lottoMatch.matchBonus == matchBonus) {
                return lottoMatch;
            }
        }
        return null;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return winningStatistics;
    }
}
