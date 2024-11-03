package lotto.domain;

public enum Prize {

    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5000, "3개 일치 (5,000원) - ");

    private final int matchCount;
    private final Boolean bonusMatch;
    private final int prizeAmount;
    private final String printSentence;
    private int count;

    Prize(int matchCount, Boolean bonusMatch, int prizeAmount, String printSentence) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeAmount = prizeAmount;
        this.printSentence = printSentence;
        this.count = 0;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Boolean getBonusMatch() {
        return bonusMatch;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return printSentence + count + "개";
    }

}
