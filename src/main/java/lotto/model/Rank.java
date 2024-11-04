package lotto.model;

public enum Rank {
    FIFTH(5000, "3개 일치", 5),
    FOURTH(50000, "4개 일치", 4),
    THIRD(1500000, "5개 일치", 3),
    SECOND(30000000, "5개 일치, 보너스 볼 일치", 2),
    FIRST(2000000000, "6개 일치", 1);

    private int prize;
    private String matchMessage;
    private int rank;

    Rank(int prize, String matchMessage, int rank) {
        this.prize = prize;
        this.matchMessage = matchMessage;
        this.rank = rank;
    }

    public int getPrize() {
        return prize;
    }

    public String getMatchMessage() {
        return matchMessage;
    }

    public int getRank() {
        return rank;
    }
}