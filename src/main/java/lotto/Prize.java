package lotto;

public enum Prize {
    First(0),
    Second(0),
    Third(0),
    Fourth(0),
    Fifth(0);

    private int prizeCount;

    Prize(int initialCount) {
        this.prizeCount = initialCount;
    }

    public int getPrizeCount() {
        return this.prizeCount;
    }

    public void increaseCount() {
        this.prizeCount++;
    }


}
