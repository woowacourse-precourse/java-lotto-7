package lotto.domain;

public enum Ranking {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    FORTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, "3개 일치 (5,000원) - ");

    private final int correctCount;
    private final int price;
    private final String message;

    private Ranking(int correctCount, int price, String message) {
        this.correctCount = correctCount;
        this.price = price;
        this.message = message;

    }

    public static Ranking valueOf(int correctCount, boolean matchBonus) {
        Ranking ranking = null;

        if (SECOND.matchCount(correctCount) && matchBonus) {
            ranking =  SECOND;
        }

        for (Ranking rank : values()) {
            if (rank.matchCount(correctCount) && rank != SECOND) {
                ranking = rank;
            }
        }

        return ranking;
    }

    private boolean matchCount(int correctCount) {
        return this.correctCount == correctCount;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}
