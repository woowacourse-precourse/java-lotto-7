package lotto;

public enum LottoWinningRank {

    FIRST("6개 일치 (2,000,000,000원) - ",false,2000000000), // 1등
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ",true,30000000),  // 2등
    THIRD("5개 일치 (1,500,000원) - ",false,1500000),    // 3등
    FOURTH("4개 일치 (50,000원) - ",false,50000),      // 4등
    FIFTH("3개 일치 (5,000원) - ", false,5000),        // 5등
    FAIL("꽝 ㅋㅋ 한번 더 사보세요~",  false,0);

    private String prizeMent;
    private boolean isBonusPrize;
    private Integer prizePrice;

    LottoWinningRank(String prizeMent, boolean isBonusPrize, Integer prizePrice) {
        this.prizeMent = prizeMent;
        this.isBonusPrize = isBonusPrize;
        this.prizePrice = prizePrice;
    }

    public String getPrizeMent() {
        return prizeMent;
    }

    public Integer getPrizePrice() {
        return prizePrice;
    }
}
