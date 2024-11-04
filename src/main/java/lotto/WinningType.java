package lotto;

public class WinningType {

    private int prize;

    public WinningType(int prize) {
        this.prize = prize;
    }

    public WinningType(WinningType winningType) {
        this.prize = winningType.prize;
    }

    public int getPrize() {
        return prize;
    }
}
