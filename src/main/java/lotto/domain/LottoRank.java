package lotto.domain;

public enum LottoRank {
    FIVE( 3, 5_000, "3개 일치 (5,000원)"),
    FOUR( 4, 50_000, "4개 일치 (50,000원)"),
    THREE( 5, 1_500_000, "5개 일치 (1,500,000원)"),
    TWO( 5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    ONE( 6, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final String message;
    private final int prize;
    private final int score;

    LottoRank(int score, int prize, String message) {
        this.score = score;
        this.prize = prize;
        this.message = message;
    }

    public static LottoRank evaluate(int lottoScore, boolean hasBonusNumber) {
        if (TWO.getScore() == lottoScore && hasBonusNumber) return TWO;
        for (LottoRank rank : values()) {
            if (rank.getScore() == lottoScore) return rank;
        }
        return null;
    }

    public int getScore() {
        return score;
    }

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }
}
