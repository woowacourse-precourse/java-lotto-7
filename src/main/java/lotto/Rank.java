package lotto;

public enum Rank {
    FIRST("1등", 2_000_000_000, 60), SECOND("2등", 30_000_000, 51), THIRD("3등", 1_500_000, 50), FOURTH("4등", 50_000, 40), FIFTH("5등", 5_000, 30), ETC("기타", 0, -1);

    private String name;
    private int prize;
    private int score;

    Rank(String name, int prize, int score) {
        this.name = name;
        this.prize = prize;
        this.score = score;
    }
}
