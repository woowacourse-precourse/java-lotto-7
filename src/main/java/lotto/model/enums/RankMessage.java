package lotto.model.enums;

public enum RankMessage {
    FIFTH(5, "3개 일치 (5,000원)", 5000),
    FOURTH(4, "4개 일치 (50,000원)", 50000),
    THIRD(3, "5개 일치 (1,500,000원)", 1500000),
    SECOND(2, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    FIRST(1, "6개 일치 (2,000,000,000원)", 2000000000);

    private final int rank;
    private final String winningMessage;
    private final int prize;

    RankMessage(int rank, String winningMessage, int prize) {
        this.rank = rank;
        this.winningMessage = winningMessage;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public String getWinningMessage() {
        return winningMessage;
    }

    public int getPrize() {
        return prize;
    }
}
