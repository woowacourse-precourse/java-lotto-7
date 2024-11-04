package lotto.model;

public enum Rank {
    MISS(-1, 0, 0, ""),
    FIFTH(3, 0, 5000, "5,000"),
    FOURTH(4, 0, 50000, "50,000"),
    THIRD(5, 0, 1500000, "1,500,000"),
    SECOND(5, 1, 30000000, "30,000,000"),
    FIRST(6, 0, 2000000000, "2,000,000,000");

    private final int numberCount;
    private final int bounsExist;
    private final int prize;
    private final String prizeString;

    Rank(int numberCount, int bounsExist, int prize, String prizeString) {
        this.numberCount = numberCount;
        this.bounsExist = bounsExist;
        this.prize = prize;
        this.prizeString = prizeString;
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
        String bounsExistString = "";
        if (rank.bounsExist == 1) {
            bounsExistString = ", 보너스 볼 일치";
            matchCount--;
        }
        System.out.printf("%d개 일치%s (%s원) - %d개\n", matchCount, bounsExistString, rank.prizeString, counter);
    }

    public static int calculatePrize(Rank rank, int counter) {
        return rank.prize * counter;
    }
}