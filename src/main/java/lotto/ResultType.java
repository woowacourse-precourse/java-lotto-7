package lotto;

import java.text.NumberFormat;

public enum ResultType {
    FIFTH("3개 일치",5000, 3),
    FOURTH("4개 일치",50000, 4),
    THIRD("5개 일치", 1500000, 5),
    SECOND("5개 일치, 보너스 볼 일치", 30000000, 7),
    FIRST("6개 일치", 2000000000, 6);

    private final String value;
    private final int reward;
    private final int count;

    ResultType(String value, int reward, int count) {
        this.value = value;
        this.reward = reward;
        this.count = count;
    }

    public String getValue() {
        return value;
    }

    public int getReward() {
        return reward;
    }

    public String getFormattedReward() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String formattedReward = numberFormat.format(this.reward).trim();
        return formattedReward;
    }

    public int getCount() {
        return count;
    }
}
