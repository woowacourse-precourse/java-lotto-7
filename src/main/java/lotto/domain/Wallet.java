package lotto.domain;

import lotto.domain.calculators.TicketCalculator;
import lotto.domain.calculators.TicketCalculatorImpl;

public class Wallet {
    private final static int MIN_PRICE_PER_LOTTO_TICKET = 1000;

    private final TicketCalculator ticketCalculator;
    private final int amount;
    private int ticket;
    private float rateOfReturn = 0;

    public Wallet(int money) {
        validateMinAmount(money);
        validateUnit(money);

        ticketCalculator = new TicketCalculatorImpl();
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


    public float getRateOfReturn() {
        return rateOfReturn;
    }


    //todo 아 이 계산하는 로직을 서비스에서 시키는것보다 calculator를 이 객체 안에 의존해줘야하나?
    public void calculateRateOfReturn(long totalPrizeMoney) {
        rateOfReturn = (float) totalPrizeMoney / amount * 100;
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
