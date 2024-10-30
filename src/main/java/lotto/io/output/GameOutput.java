package lotto.io.output;

import lotto.LottoTicket;
import lotto.Result;

public interface GameOutput {
    void printPurchasedTickets(LottoTicket lottoTicket);

    void printResults(Result result, int totalPrice);
}

