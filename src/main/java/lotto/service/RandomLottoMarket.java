package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Wallet;
import lotto.domain.calculators.TicketCalculator;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.number.NumbersMaker;

public class RandomLottoMarket {
    private final TicketCalculator ticketCalculator;
    private final NumbersMaker numbersMaker;
    private final Wallet wallet;

    public RandomLottoMarket(TicketCalculator ticketCalculator, NumbersMaker randomNumberMaker, Wallet wallet) {
        this.ticketCalculator = ticketCalculator;
        this.numbersMaker = randomNumberMaker;
        this.wallet = wallet;
    }

    public RandomLottos createRandomLottos() {
        buyTicket();
        int ticket = wallet.getTicket();

        return new RandomLottos(makeLottos(ticket));
    }

    public List<Lotto> makeLottos(int ticket) {
        List<Lotto> resultRandomLottos = new ArrayList<>();

        for (int i = 0; i < ticket; i++) {
            resultRandomLottos.add(makeLotto());
        }
        return resultRandomLottos;
    }

    private Lotto makeLotto() {
        List<Integer> randomNumbers = numbersMaker.make();
        return new Lotto(randomNumbers);
    }

    private void buyTicket() {
        wallet.calculateNumberOfTicket(ticketCalculator);
    }

}
