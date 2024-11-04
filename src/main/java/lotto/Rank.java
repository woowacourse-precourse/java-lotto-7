package lotto;

import java.text.DecimalFormat;

public enum Rank {

    FIRST(1,6, 2000000000),
    SECOND(2, 5, 30000000),
    THIRD(3, 5, 1500000),
    FORTH(4, 4, 50000),
    FIFTH(5, 3, 5000);

    private int serial;
    private int match;
    private int amount;

    public static Rank[] ranks = {
            FIRST,SECOND,THIRD, FORTH, FIFTH
    };

    private Rank(int serial, int match, int amount) {
        this.serial = serial;
        this.match =  match;
        this.amount = amount;
    }

    public int getSerial() {
        return serial;
    }

    public int getMatch() {
        return match;
    }

    public int getAmount() {
        return amount;
    }
}
