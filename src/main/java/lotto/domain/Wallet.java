package lotto.domain;

import static lotto.domain.InputErrorMessage.PURCHASE_AMOUNT_MINIMUM;
import static lotto.domain.InputErrorMessage.PURCHASE_AMOUNT_UNIT;

import lotto.domain.calculators.TicketCalculator;
import lotto.domain.calculators.YieldCalculator;

public class Wallet {
    private final static int MIN_PRICE_PER_LOTTO_TICKET = 1000;

    private final int amount;
    private float rateOfReturn = 0;

    public Wallet(int money) {
        validateMinAmount(money);
        validateUnit(money);

        this.amount = money;
    }

    public int calculateNumberOfTicket(TicketCalculator ticketCalculator) {
        return ticketCalculator.calculate(amount);
    }

    public void calculateRateOfReturn(YieldCalculator yieldCalculator, long finalPrizeAmount) {
        rateOfReturn = yieldCalculator.calculate(finalPrizeAmount, amount);
    }


    public float getRateOfReturn() {
        return rateOfReturn;
    }


    private void validateMinAmount(int money) {
        if (money < MIN_PRICE_PER_LOTTO_TICKET) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_MINIMUM.getMessage());
        }
    }

    private void validateUnit(int money) {
        if (money % MIN_PRICE_PER_LOTTO_TICKET != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT.getMessage());
        }
    }

}
