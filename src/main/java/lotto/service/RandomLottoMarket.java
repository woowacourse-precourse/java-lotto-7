package lotto.service;

import lotto.domain.Wallet;
import lotto.domain.calculators.TicketCalculator;
import lotto.domain.lottos.RandomLottos;

public class RandomLottoMarket {
    private final TicketCalculator ticketCalculator;
    private final RandomLottos randomLottos;
    private final Wallet wallet;

    public RandomLottoMarket(TicketCalculator ticketCalculator, RandomLottos randomLottos, Wallet wallet) {
        this.ticketCalculator = ticketCalculator;
        this.randomLottos = randomLottos;
        this.wallet = wallet;
    }

    public void createRandomLottos() {
        buyTicket();
        int ticket = wallet.getTicket();
        randomLottos.makeLottos(ticket);
    }

    private void buyTicket() {
        wallet.calculateNumberOfTicket(ticketCalculator);
    }

}
