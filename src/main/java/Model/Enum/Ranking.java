package Model.Enum;

public enum Ranking {
    FIFTH_RANK(3),
    FOURTH_RANK(4),
    THIRD_RANK(5),
    SECOND_RANK(5),
    FIRST_RANK(6);

    private final int ranking;

    Ranking(int ranking) {
        this.ranking = ranking;
    }

    public int get() {
        return ranking;
    }
}