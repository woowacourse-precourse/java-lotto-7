package lotto.domain.calculators;

public class TicketCalculatorImpl implements TicketCalculator {
    public final static int PRICE_OF_ONE_TICKET = 1000;

    @Override
    public int calculate(int amount) {
        return amount / PRICE_OF_ONE_TICKET;
    }

}
