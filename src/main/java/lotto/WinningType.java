package lotto;

public class WinningType {

    private int sameCount;
    private int prize;

    public WinningType(int sameCount, int prize) {
        this.sameCount = sameCount;
        this.prize = prize;
    }

    public WinningType(WinningType winningType) {
        this.prize = winningType.prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getSameCount() {
        return sameCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinningType)) {
            return false;
        }
        WinningType winningType = (WinningType) o;
        return prize == winningType.prize;
    }
}
