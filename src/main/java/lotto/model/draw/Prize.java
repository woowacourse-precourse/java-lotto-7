package lotto.model.draw;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Prize {

    FIRST(1,6, 2000000000, "%S개 일치 (%S원)"),
    SECOND(2,5, 30000000, "%S개 일치, 보너스 볼 일치 (%S원)"),
    THIRD(3,5, 1500000, "%S개 일치 (%S원)"),
    FOURTH(4,4, 50000, "%S개 일치 (%S원)"),
    FIFTH(5,3, 5000, "%S개 일치 (%S원)"),
    BLANK(6,0,0,"%S개 일치");

    private static final String MONEY_UNIT_PATTERN = "###,###";

    private final int rank;
    private final int conditionCount;
    private final int prizeMoney;
    private final String message;

    Prize(int rank, int conditionCount, int prizeMoney, String message) {
        this.rank = rank;
        this.conditionCount = conditionCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public static Prize findPrize(int sameNumberCount, boolean isContainBonusNumber) {
        Prize prize = Arrays.stream(values())
                .filter(value -> sameNumberCount == value.getConditionCount())
                .findFirst()
                .orElse(BLANK);

        if (prize.equals(SECOND) && !isContainBonusNumber) {
            prize = THIRD;
        }
        return prize;
    }

    public int calculatePrizeMoney(int count) {
        return prizeMoney*count;
    }

    public int getRank() {
        return rank;
    }

    public int getConditionCount() {
        return conditionCount;
    }

    public String getMessage() {
        DecimalFormat decimalFormat = new DecimalFormat(MONEY_UNIT_PATTERN);
        String money = decimalFormat.format(prizeMoney);
        return String.format(message,conditionCount,money);
    }

}
