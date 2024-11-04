package lotto.Enum;

public enum LottoPrizeRank {
    FIRST(1, 6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(2, 5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(3, 5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(5, 3, 5_000, "3개 일치 (5,000원)"),
    MISS(6, 0, 0, "일치하는 번호가 없습니다.");

    public final int rank;
    public final int matchCount;
    public final int prize;
    public final String resultMessage;

    LottoPrizeRank(int rank, int matchCount, int prize, String resultMessage) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prize = prize;
        this.resultMessage = resultMessage;
    }
}
