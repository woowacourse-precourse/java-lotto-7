package lotto;

public enum LottoPrizeDetail {
    THREE(3, "3개 일치 (5,000원)", 5_000f),
    FOUR(4, "4개 일치 (50,000원)", 50_000f),
    FIVE(5, "5개 일치 (1,500,000원)", 1_500_000f),
    BONUS(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000f),
    SIX(6, "6개 일치 (2,000,000,000원)", 2_000_000_000f);

    private final String detailIntro;
    private final Integer matchNumber;
    private final Float winningPrizes;

    LottoPrizeDetail(Integer matchNumber, String intro, Float winningPrizes) {
        this.matchNumber = matchNumber;
        this.detailIntro = intro;
        this.winningPrizes = winningPrizes;
    }

    public Integer getMatchNumber() {
        return matchNumber;
    }

    public String getDetailIntro() {
        return detailIntro;
    }

    public Float getWinningPrizes() {
        return winningPrizes;
    }
}
