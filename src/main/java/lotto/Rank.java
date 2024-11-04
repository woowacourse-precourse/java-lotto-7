package lotto;

public enum Rank {

    FIRST_PLACE(6, false),
    SECOND_PLACE(5, true),
    THIRD_PLACE(5, false),
    FORTH_PLACE(4, false),
    FIFTH_PLACE(3, false);

    private int rank;
    private boolean requiredBonusNumber;

    Rank(int rank, boolean requiredBonusNumber) {
        this.rank = rank;
        this.requiredBonusNumber = requiredBonusNumber;
    }
}
