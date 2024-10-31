package lotto;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FORTH(4, 50000),
    FIFTH(3, 5000);

    private int match;
    private int amount;
    private int count = 0;

    public static Rank[] ranks = {
            FIRST,SECOND,THIRD, FORTH, FIFTH
    };

    private Rank(int match, int amount) {
        this.match =  match;
        this.amount = amount;
    }
}
