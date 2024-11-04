package lotto;

import java.text.DecimalFormat;

public enum Match {

    MATCH_3(3, 5_000), MATCH_4(4, 50_000),
    MATCH_5(5, 1_500_000),
    MATCH_5_BONUS(5, 30_000_000),
    MATCH_6(6, 2_000_000_000);


    private final int match;
    private final int value;
    private int count;

    Match(int match, int value) {
        this.match = match;
        this.value = value;
        this.count = 0;
    }

    public void numberMatch() {
        count++;
    }

    public int getMatch() {
        return match;
    }

    public int getCount() {
        return count;
    }

    public int getValue() {
        return value;
    }

    public String matchToString(DecimalFormat formatter) {
        if (getValue() == 30_000_000) {
            return match + "개 일치, 보너스 볼 일치 ("
                    + formatter.format(value)
                    + "원) - " + count + "개";
        }

        return match + "개 일치 (" + formatter.format(value)
                + "원) - " + count + "개";
    }

    public void init() {
        count = 0;
    }
}
