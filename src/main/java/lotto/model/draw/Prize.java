package lotto.model.draw;

import java.text.DecimalFormat;
import java.util.Arrays;
// 로또 등수에 해당하는 보상을 관리하는 객체
public enum Prize {
    // 각 등수별로 rank 값도 보유하고 있어서 추후 Map에서 Prize를 Key값으로 이용할 때 compare용으로 이용 가능
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
    // 로또와 승리 로또를 비교했을 때 일치하는 갯수와 보너스 넘버 보유 여부에 따라 등수에 맞는 보상을 반환한다.
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

    public int getRank() {
        return rank;
    }

    public int getConditionCount() {
        return conditionCount;
    }

    public int sumPrizeMoney(int count) {
        return prizeMoney*count;
    }

    public String getMessage() {
        DecimalFormat decimalFormat = new DecimalFormat(MONEY_UNIT_PATTERN);
        String money = decimalFormat.format(prizeMoney);
        return String.format(message,conditionCount,money);
    }

}
