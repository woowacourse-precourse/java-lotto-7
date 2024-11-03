package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;
import lotto.factory.LottoMachine;

import java.util.List;
import java.util.stream.IntStream;

public class LottoBuyer {

    public LottoTickets buyLottoTickets(LottoMachine lottoMachine, Money money) {
        if (money == null) {
            throw new LottoException(ErrorMessages.MONEY_NULL);
        }

        int buyCount = money.divide(LottoMachine.PRICE_PER_ONE);
        return generateLottoTickets(lottoMachine, buyCount);
    }

    private LottoTickets generateLottoTickets(LottoMachine lottoMachine, int ticketCount) {
        List<LottoTicket> tickets = IntStream.range(0, ticketCount)
                .mapToObj(i -> lottoMachine.generateLottoTicket())
                .toList();
        return new LottoTickets(tickets);
    }
}
