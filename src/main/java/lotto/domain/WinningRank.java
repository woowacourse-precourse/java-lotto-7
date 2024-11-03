package lotto.domain;

public enum WinningRank {
    NONE(0, 0, -1, null),
    FIFTH(3, 5_000, -1, "3개 일치 (5,000원)"),
    FOURTH(4, 50_000, -1, "4개 일치 (50,000원)"),
    THIRD(5, 1_500_000, -1, "5개 일치 (1,500,000원)"),
    SECOND(5, 30_000_000, 1, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2_000_000_000, -1, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final int prize;
    private final int bonusNumMatch; // 보너스 번호는 2등일 경우에만 유효,
    private final String resultMessage;

    WinningRank(int matchCount, int prize, int bonusMatch, String resultMessage) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonusNumMatch = bonusMatch;
        this.resultMessage = resultMessage;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public int getBonusNumMatch() {
        return bonusNumMatch;
    }

}
