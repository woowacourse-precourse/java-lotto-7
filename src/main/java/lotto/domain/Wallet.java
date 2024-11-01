package lotto.domain;

import lotto.domain.calculators.TicketCalculator;
import lotto.domain.calculators.YieldCalculator;

public class Wallet {
    private final static int MIN_PRICE_PER_LOTTO_TICKET = 1000;

    private final int amount;
    private int ticket;
    private float rateOfReturn = 0;

    public Wallet(int money) {
        validateMinAmount(money);
        validateUnit(money);

        this.amount = money;
    }

    public void calculateNumberOfTicket(TicketCalculator ticketCalculator) {
        ticket = ticketCalculator.calculate(amount);
    }

    public void calculateRateOfReturn(YieldCalculator yieldCalculator, long finalPrizeAmount) {
        rateOfReturn = yieldCalculator.calculate(finalPrizeAmount, amount);
    }


    public int getTicket() {
        return ticket;
    }

    public float getRateOfReturn() {
        return rateOfReturn;
    }


    private void validateMinAmount(int money) {
        if (money < MIN_PRICE_PER_LOTTO_TICKET) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 1,000원 입니다.");
        }
    }

    private void validateUnit(int money) {
        if (money % MIN_PRICE_PER_LOTTO_TICKET != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위로 입력해 주세요.");
        }
    }

}
