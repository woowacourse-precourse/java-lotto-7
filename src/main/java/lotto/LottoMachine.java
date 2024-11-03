package lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int START_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    private LottoTickets lottoTickets;

    public void purchase(Cash cash) {
        int ticketCount = cash.getTicketCount();
        List<Lotto> tickets = createTickets(ticketCount);

        lottoTickets = new LottoTickets(tickets);
    }

    private List<Lotto> createTickets(int ticketCount) {
        return IntStream.range(0, ticketCount)
            .mapToObj(i -> new Lotto(
                RandomNumber.getUniqueNumbers(START_LOTTO_NUMBER, LAST_LOTTO_NUMBER, LOTTO_COUNT)
            ))
            .toList();
    }

    public int currentLottoTicketCount() {
        return lottoTickets.getTicketCount();
    }

    public String currentLottoTicketNumbers() {
        return lottoTickets.toString();
    }
}
