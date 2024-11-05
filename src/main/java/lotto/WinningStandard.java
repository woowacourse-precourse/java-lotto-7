package lotto;

public enum WinningStandard {
    FIFTHPLACE(3, false, 5000, "5,000"),
    FOURTHPLACE(4, false, 50000, "50,000"),
    THIRDPLACE(5, false, 1500000, "1,500,000"),
    SECONDPLACE(5, true, 30000000, "30,000,000"),
    FIRSTPLACE(6, false, 2000000000, "2,000,000,000");

    private final long matchingNumber;
    private final boolean matchingBonusNumber;
    private final long prize;
    private final String prizeForPrint;

    WinningStandard(long matchingNumber, boolean matchingBonusNumber, long prize, String prizeForPrint) {
        this.matchingNumber = matchingNumber;
        this.matchingBonusNumber = matchingBonusNumber;
        this.prize = prize;
        this.prizeForPrint = prizeForPrint;
    }

    public long getMatchingNumber() {
        return matchingNumber;
    }

    public boolean isMatchingBonusNumber() {
        return matchingBonusNumber;
    }

    public long getPrize() {
        return prize;
    }

    public String getPrizeForPrint() {
        return prizeForPrint;
    }
}
