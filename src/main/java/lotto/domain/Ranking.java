package lotto.domain;

public enum Ranking {

    FIRST_PLACE(6, false, 2_000_000_000),
    SECOND_PLACE(5, true, 30_000_000),
    THIRED_PLACE(5, false, 1_500_000),
    FOURTH_PLACE(4, false, 50_000),
    FIFTH_PLACE(3, false, 5_000),
    LAST_PLACE(0, false, 0);

    private final int matchingCount;
    private final boolean containBonusNumber;
    private final int winningPrice;

    Ranking(int matchingCount, boolean containBonusNumber, int winningPrice) {
        this.matchingCount = matchingCount;
        this.containBonusNumber = containBonusNumber;
        this.winningPrice = winningPrice;
    }

}
