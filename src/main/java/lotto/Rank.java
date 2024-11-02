package lotto;

public enum Rank {

    FIRST("1등"),
    SECOND("2등"),
    THIRD("3등"),
    FOURTH("4등"),
    FIFTH("5등"),
    NONE("꽝");

    private final String name;

    Rank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
