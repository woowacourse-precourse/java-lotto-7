package lotto;

public enum WinningCriteria {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", true),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, "3개 일치 (5,000원) - ");

    private final int matchingCondition;
    private final int prize;
    private final String printFormat;
    // 이게 필요할까?
    private final boolean bonusMatch;

    WinningCriteria(int matchingCondition, int prize, String printFormat) {
        this(matchingCondition, prize, printFormat, false);
    }

    WinningCriteria(int matchingCondition, int prize, String printFormat, boolean bonusMatch) {
        this.matchingCondition = matchingCondition;
        this.prize = prize;
        this.printFormat = printFormat;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchingCondition() {
        return this.matchingCondition;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getPrintFormat() {
        return this.printFormat;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public boolean meet(int matchingCount) {
        return this.matchingCondition == matchingCount;
    }
}
