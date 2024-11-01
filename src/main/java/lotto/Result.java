package lotto;

public enum Result {
    FIRST(2000000000, 0, 6),
    SECOND(30000000, 0, 7),
    THIRD(1500000, 0, 5),
    FOURTH(50000, 0, 4),
    FIFTH(5000, 0, 3);

    private final int money;
    private int count;
    private final int matches;

    Result(int money, int count, int matches) {
        this.money = money;
        this.count = count;
        this.matches = matches;
    }

    public int getCount() {
        return count;
    }

    public void increamentCount() {
        this.count++;
    }

    public int getMatches() {
        return matches;
    }
}
