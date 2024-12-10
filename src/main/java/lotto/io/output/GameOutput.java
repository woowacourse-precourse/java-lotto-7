package lotto.io.output;

import lotto.domain.LottoTicket;
import lotto.domain.Result;

public interface GameOutput {
    void printPurchasedTickets(LottoTicket lottoTicket);

    void printResults(Result result, String yield);

    void printErrorMessage(String message);

    void close();
}
