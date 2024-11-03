package lotto.model;

import java.text.DecimalFormat;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private int count;
    private boolean bonusNumber;
    private int prizeMoney;

    Prize(int count, boolean bonusNumber, int prizeMoney) {
        this.count = count;
        this.bonusNumber = bonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public int getCount() {
        return count;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("###,###,###,###");

        if (bonusNumber) {
            return count + "개 일치, 보너스 볼 일치 (" + formatter.format(prizeMoney) + "원) - ";
        }
        return count + "개 일치 (" + formatter.format(prizeMoney) + "원) - ";
    }
}
