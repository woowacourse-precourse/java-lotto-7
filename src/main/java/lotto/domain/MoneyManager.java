package lotto.domain;

import lotto.util.Formatter;

public class MoneyManager {

    private static final Long MONEY_UNIT = 1000L;
    private static final Long MONEY_MIN = 0L;

    private final Long purchaseMoney;
    private Long prizeMoney;

    public MoneyManager(Long purchaseMoney) {
        validatePurchaseMoney(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    public void setPrizeMoney(Long money) {
        prizeMoney = money;
    }

    private void validatePurchaseMoney(Long money) {
        validateMoneyUnit(money);
        validateMoneyRange(money);
    }

    private void validateMoneyRange(Long money) {
        if (money <= MONEY_MIN) {
            throw new IllegalArgumentException(String.format("%s원 보다 큰 금액을 입력해주세요.", Formatter.formatToCurrency(MONEY_MIN)));
        }
    }

    private void validateMoneyUnit(Long money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(String.format("%s원 단위로 입력해주세요.", Formatter.formatToCurrency(MONEY_UNIT)));
        }
    }

    public double getReturnRate() {
        validateNullPrizeMoney();

        return ((double) prizeMoney / purchaseMoney) * 100;
    }

    private void validateNullPrizeMoney() {
        if (prizeMoney == null) {
            throw new IllegalArgumentException("로또 당첨 금액부터 입력주세요.");
        }
    }
}
