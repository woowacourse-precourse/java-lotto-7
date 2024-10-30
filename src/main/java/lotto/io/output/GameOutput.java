package lotto.io.output;

import lotto.Result;
import lotto.domain.LottoTicket;

public interface GameOutput {
    void printPurchasedTickets(LottoTicket lottoTicket);

    void printResults(Result result, double yield);
}

