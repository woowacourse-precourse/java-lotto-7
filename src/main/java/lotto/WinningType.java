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
