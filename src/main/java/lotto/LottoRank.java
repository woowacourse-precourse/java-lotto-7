package lotto;

public enum LottoRank {
    NONE_RANK(0),
    FIRST_RANK(1),
    SECOND_RANK(2),
    THIRD_RANK(3),
    FIRTH_RANK(4),
    FIFTH_RANK(5);

    private final int rank;
    LottoRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
