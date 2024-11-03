package lotto.constants;

import java.util.Arrays;

public enum Ranking {

    ZERO(0,0,"0"),
    ONE(1,0,"0"),
    TWO(2,0,"0"),
    THREE(3,5000,"5,000"),
    FOUR(4,50000,"50,000"),
    FIVE(5,1500000,"1,500,000"),
    FIVE_BONUS(5,30000000,"30,000,000"),
    SIXTH(6,2000000000,"2,000,000,000");

    final private int count;
    final private int winnings;
    final private String strWinnings;

    Ranking(int count, int winnings, String strWinnings) {
        this.count = count;
        this.winnings = winnings;
        this.strWinnings = strWinnings;
    }

    public int getCount() {
        return count;
    }

    public int getWinnings() {
        return winnings;
    }

    public String getStrWinnings() {
        return strWinnings;
    }


}
