package lotto;

public enum WinningStatus {
    NO_WIN(0, 0),
    FIFTH_PLACE(5_000, 3),
    FOURTH_PLACE(50_000, 4),
    THIRD_PLACE(1_500_000, 5),
    SECOND_PLACE(30_000_000, 5),
    FIRST_PLACE(2_000_000_000, 6);

    private final int prize;
    private final int correct;

    WinningStatus(int prize, int correct) {
        this.prize = prize;
        this.correct = correct;
    }

    public int getPrize() {
        return prize;
    }

    public int getCorrect() {
        return correct;
    }
}
