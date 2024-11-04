package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST("6개 일치", 2_000_000_000, 60), SECOND("5개 일치, 보너스 볼 일치", 30_000_000, 51), THIRD("5개 일치", 1_500_000, 50), FOURTH("4개 일치", 50_000, 40), FIFTH("3개 일치", 5_000, 30), ETC("2개 미만", 0, -1);

    private String condition;
    private int prize;
    private int score;

    Rank(String condition, int prize, int score) {
        this.condition = condition;
        this.prize = prize;
        this.score = score;
    }

    public static Rank getRankByScore(int score) {
        return Arrays.stream(values())
                .filter(value -> value.score == score)
                .findFirst()
                .orElse(ETC);
    }

    public String toString() {
        return String.format("%s (%,d)", condition, prize);
    }
}
