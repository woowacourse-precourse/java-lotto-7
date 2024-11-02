package lotto.domain;

import lotto.util.Formatter;

public class MoneyManager {

    private static final Long MONEY_UNIT = 1000L;

    private final Long purchaseMoney;
    private Long prizeMoney;

    public MoneyManager(Long purchaseMoney) {
        validationPurchaseMoney(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    public void setPrizeMoney(Long prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    private void validationPurchaseMoney(Long money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(String.format("%s원 단위로 입력해주세요.", Formatter.formatToCurrency(MONEY_UNIT)));
        }
    }

    public double getReturnRate() {
        if (prizeMoney == null) {
            throw new IllegalArgumentException("로또 당첨 금액부터 입력주세요.");
        }

        return ((double) prizeMoney / purchaseMoney) * 100;
    }
}
