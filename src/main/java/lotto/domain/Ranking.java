package lotto.domain;

public enum Ranking {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    FORTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    MISS(0, 0, "");

    private final int correctCount;
    private final int price;
    private final String message;

    private Ranking(int correctCount, int price, String message) {
        this.correctCount = correctCount;
        this.price = price;
        this.message = message;

    }

    public static Ranking valueOf(int correctCount, boolean matchBonus) {
        if (correctCount < 3) {
            return MISS;
        }

        if (SECOND.matchCount(correctCount) && matchBonus) {
            return SECOND;
        }

        for (Ranking rank : values()) {
            if (rank.matchCount(correctCount) && rank != SECOND) {
                return rank;
            }
        }
        throw new IllegalArgumentException("");
    }

    private boolean matchCount(int correctCount) {
        return this.correctCount == correctCount;
    }


    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}
