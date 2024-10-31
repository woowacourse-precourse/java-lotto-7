package lotto.io.output.impl;

import lotto.common.ConsoleMessages;
import lotto.domain.LottoTicket;
import lotto.domain.Result;
import lotto.io.output.GameOutput;

public class OutputConsole implements GameOutput {
    @Override
    public void printPurchasedTickets(LottoTicket lottoTicket) {
        System.out.printf(ConsoleMessages.PURCHASED_TICKETS_MESSAGE, lottoTicket.size());
        lottoTicket.getTickets().forEach(System.out::println);
    }

    @Override
    public void printResults(Result result, double yield) {
        System.out.println(ConsoleMessages.WINNING_STATISTICS_HEADER);
        result.getFormattedResults().forEach(System.out::println);
        System.out.printf(ConsoleMessages.YIELD_MESSAGE, yield);
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println(ConsoleMessages.ERROR_PREFIX + message);
    }
}
