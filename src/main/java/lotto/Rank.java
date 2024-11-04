package lotto;

public enum Rank {
    FIRST(6, 0, "2,000,000,000"),
    SECOND(5, 1, "30,000,000"),
    THIRD(5, 0, "1,500,000"),
    FOURTH(4, 0, "50,000"),
    FIFTH(3, 0, "5,000"),
    MISS(-1, 0, "");

    private final int numberCount;
    private final int bounsExist;
    private final String prize;

    Rank(int numberCount, int bounsExist, String prize) {
        this.numberCount = numberCount;
        this.bounsExist = bounsExist;
        this.prize = prize;
    }

    public static Rank checkRank(int numberCount, int bounsExist) {
        for (Rank rank : Rank.values()) {
            if (rank.numberCount == numberCount && rank.bounsExist == bounsExist) {
                return rank;
            }
        }
        return MISS;
    }

    public static void printRankPrize(Rank rank, int counter) {
        int matchCount = rank.numberCount + rank.bounsExist;
        System.out.printf("%d개 일치 (%s)원 - %d개\n", matchCount, rank.prize, counter);
    }
}