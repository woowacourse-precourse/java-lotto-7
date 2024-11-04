package lotto.model;

import static lotto.constants.NumberConstants.CASH_PRIZE_3;
import static lotto.constants.NumberConstants.CASH_PRIZE_4;
import static lotto.constants.NumberConstants.CASH_PRIZE_5;
import static lotto.constants.NumberConstants.CASH_PRIZE_5_BONUS;
import static lotto.constants.NumberConstants.CASH_PRIZE_6;
import static lotto.constants.NumberConstants.GET_3;
import static lotto.constants.NumberConstants.GET_4;
import static lotto.constants.NumberConstants.GET_5;
import static lotto.constants.NumberConstants.GET_6;
import static lotto.constants.NumberConstants.ZERO;

public class WinningPriceStore {

    private final int numberMatchCount;
    private final boolean isBonus;
    private final int matchPrice;
    private int lottoCount;
    private long totalPrice;

    public WinningPriceStore(int numberMatchCount, boolean isBonus) {
        this.numberMatchCount = numberMatchCount;
        this.isBonus = isBonus;
        this.matchPrice = getMatchPrice(numberMatchCount, isBonus);
        this.lottoCount = 0;
        this.totalPrice = 0L;
    }

    private int getMatchPrice(int numberMatchCount, boolean isBonus) {
        if (numberMatchCount == GET_3) {
            return CASH_PRIZE_3;
        }
        if (numberMatchCount == GET_4) {
            return CASH_PRIZE_4;
        }
        if (numberMatchCount == GET_5 && isBonus) {
            return CASH_PRIZE_5_BONUS;
        }
        if (numberMatchCount == GET_5) {
            return CASH_PRIZE_5;
        }
        if (numberMatchCount == GET_6) {
            return CASH_PRIZE_6;
        }
        return ZERO;
    }

    public void addMatchLotto() {
        lottoCount++;
        totalPrice += matchPrice;
    }

    public int getNumberMatchCount() {
        return numberMatchCount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getMatchPrice() {
        return matchPrice;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public long getTotalPrice() {
        return totalPrice;
    }
}
