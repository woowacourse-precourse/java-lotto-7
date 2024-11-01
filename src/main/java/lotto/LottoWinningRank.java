package lotto;

public enum LottoWinningRank {

    FIRST("6개 일치 (2,000,000,000원) - ",false), // 1등
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ",true),  // 2등
    THIRD("5개 일치 (1,500,000원) - ",false),    // 3등
    FOURTH("4개 일치 (50,000원) - ",false),      // 4등
    FIFTH("3개 일치 (5,000원) - ", false),        // 5등
    FAIL("꽝 ㅋㅋ 한번 더 사보세요~",  false);

    private String prizeMent;
    private boolean isBonusPrize;

    LottoWinningRank(String prizeMent, boolean isBonusPrize) {
        this.prizeMent = prizeMent;
        this.isBonusPrize = isBonusPrize;
    }

    public String getPrizeMent() {
        return prizeMent;
    }

    public boolean isBonusPrize() {
        return isBonusPrize;
    }
}
