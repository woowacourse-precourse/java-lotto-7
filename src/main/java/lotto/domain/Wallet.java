package lotto.domain;

import lotto.domain.calculators.TicketCalculator;
import lotto.domain.calculators.TicketCalculatorImpl;
import lotto.domain.calculators.YieldCalculator;

public class Wallet {
    private final static int MIN_PRICE_PER_LOTTO_TICKET = 1000;

    private final TicketCalculator ticketCalculator;
    private final YieldCalculator yieldCalculator;
    private final int amount;
    private int ticket;
    private float rateOfReturn = 0;

    public Wallet(int money) {
        validateMinAmount(money);
        validateUnit(money);

        //todo 컨트롤러 의존성 주입
        ticketCalculator = new TicketCalculatorImpl();
        yieldCalculator = new YieldCalculator();
        this.amount = money;
    }

    public void buyTicket() {
        ticket = ticketCalculator.calculate(amount);
    }

    public boolean isRunOutTicket() {
        return ticket <= 0;
    }

    public void decreaseTicket() {
        ticket--;
    }

    public void calculateRateOfReturn(long finalPrizeAmount) {
        rateOfReturn = yieldCalculator.calculate(finalPrizeAmount, amount);
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

    @Override
    public String toString() {
        int calculate = ticketCalculator.calculate(amount);
        return String.valueOf(calculate);
    }


}
