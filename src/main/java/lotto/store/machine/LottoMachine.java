package lotto.store.machine;

import java.util.List;
import java.util.stream.IntStream;
import lotto.store.user.Cash;
import lotto.store.user.Lotto;
import lotto.store.LottoNumber;
import lotto.store.user.LottoTickets;
import lotto.util.RandomNumber;

public class LottoMachine {

    private LottoTickets lottoTickets;

    public void purchase(Cash cash) {
        int ticketCount = cash.getTicketCount();
        List<Lotto> tickets = createTickets(ticketCount);

        lottoTickets = LottoTickets.from(tickets);
    }

    public LottoTickets currentLottoTickets() {
        return lottoTickets;
    }

    public int currentLottoTicketCount() {
        return lottoTickets.getTicketCount();
    }

    public String currentLottoTicketNumbers() {
        return lottoTickets.toString();
    }

    private List<Lotto> createTickets(int ticketCount) {
        return IntStream.range(0, ticketCount)
            .mapToObj(i -> createLotto())
            .toList();
    }

    private Lotto createLotto() {
        return Lotto.from(
            RandomNumber.getUniqueNumbers(
                LottoNumber.START.getValue(),
                LottoNumber.LAST.getValue(),
                LottoNumber.COUNT.getValue()
            )
        );
    }

}
