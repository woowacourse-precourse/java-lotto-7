package lotto.domain;

public enum LottoRanking {
    FIRST(6, false, "6개 일치 (2,000,000,000원)", 2_000_000_000),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    THIRD(5, false, "5개 일치 (1,500,000원)", 1_500_000),
    FOURTH(4, false, "4개 일치 (50,000원)", 50_000),
    FIFTH(3, false, "3개 일치 (5,000원)", 5_000),
    NOTHING(0, false, "", 0);

    private final int matchCount;
    private final boolean checkBonusNumber;
    private final String status;
    private final int prize;

    LottoRanking(int matchCount, boolean checkBonusNumber, String status, int prize) {
        this.matchCount = matchCount;
        this.checkBonusNumber = checkBonusNumber;
        this.status = status;
        this.prize = prize;
    }

    public boolean isMatchRanking(int matchCount, boolean checkBonusNumber) {
        return this.matchCount == matchCount && this.checkBonusNumber == checkBonusNumber;
    }

    public String getStatus() {
        return this.status;
    }

    public int getPrize() {
        return this.prize;
    }
}
