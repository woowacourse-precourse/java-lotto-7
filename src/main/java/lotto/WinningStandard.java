package lotto;

public enum WinningStandard {
    FIRSTPLACE(6, false, 2000000000),
    SECONDPLACE(5, true, 30000000),
    THIRDPLACE(5, false, 1500000),
    FOURTHPLACE(4, false, 50000),
    FIFTHPLACE(3, false, 5000);

    private int matchingNumber;
    private boolean matchingBonusNumber;
    private int prize;

    WinningStandard(int matchingNumber, boolean matchingBonusNumber, int prize) {
        this.matchingNumber = matchingNumber;
        this.matchingBonusNumber = matchingBonusNumber;
        this.prize = prize;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public boolean isMatchingBonusNumber() {
        return matchingBonusNumber;
    }

    public int getPrize() {
        return prize;
    }
}
