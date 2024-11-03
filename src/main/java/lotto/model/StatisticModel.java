package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import lotto.constant.ExceptionMessage;
import lotto.entity.Prize;
import lotto.entity.PurchaseAmount;

public class StatisticModel {

    private final Map<Prize, Long> prizes;
    private PurchaseAmount purchaseAmount;
    private long prizeMoney;

    public StatisticModel() {
        this.prizes = new LinkedHashMap<>();
        prizes.put(Prize.FIFTH, 0L);
        prizes.put(Prize.FOURTH, 0L);
        prizes.put(Prize.THIRD, 0L);
        prizes.put(Prize.SECOND, 0L);
        prizes.put(Prize.FIRST, 0L);

        prizeMoney = 0L;
    }

    public Map<Prize, Long> getPrizes() {
        return prizes;
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public void setPurchaseAmount(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void add(Prize prize) {
        validatePurchaseAmountExist();
        prizes.put(prize, prizes.get(prize) + 1);
        prizeMoney += prize.getMoney();
    }

    private void validatePurchaseAmountExist() {
        if (purchaseAmount == null) {
            throw new NoSuchElementException(ExceptionMessage.PURCHASE_AMOUNT_NOT_SETTING);
        }
    }
}
